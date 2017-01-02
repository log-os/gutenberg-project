/**
 * 
 */
package social.logos.epubmaker.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import onix.social.logos.GutenbergProduct;

/**
 * @author naresh
 *
 */
public class GutenbergProject {

	/**
	 * @param args
	 */
	// ftp://gutenberg.pglaf.org/mirrors/gutenberg/cache/epub/9982/pg9982-images.epub
	public static void copyEpubFile(int id) {
		String fileName = "pg" + id + "-images.epub";
		int port = 21;
		String fromServer = "gutenberg.pglaf.org";
		String toServer = "ftp.logos.social";

		String srcUser = "anonymous";
		String srcPass = "";
		String destUser = "";
		String destPass = "";

		FTPClient srcftpClient = new FTPClient();
		FTPClient destftpClient = new FTPClient();
		boolean success = false;
		String srcPath = "/mirrors/gutenberg/cache/epub/" + id + "/";
		String srcFile = srcPath + fileName;
		String tmpPath = "/opt/logos/dropbox/tmp/gutenberg/" + id + "/";
		String tmpFile = tmpPath + fileName;

		File tmpFileObject = new File(tmpFile);
		// String downloadPath =
		// GlobalConfig.getDownloadroot()+"/"+localpath+"/"+filename;

		try {
			srcftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
			destftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

			srcftpClient.connect(fromServer, port);
			srcftpClient.login(srcUser, srcPass);
			// ftpClient.enterLocalActiveMode();
			srcftpClient.enterLocalPassiveMode();
			int replyCode = srcftpClient.getReplyCode();
			System.out.println("Ftp Client :" + fromServer + " path" + srcFile + "Response Code:" + replyCode);
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Connect failed");
				return;
			}
			srcftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			System.out.println("Source Ftp File: " + srcFile);
			tmpFileObject.getParentFile().mkdirs();
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(tmpFileObject));
			success = srcftpClient.retrieveFile(srcFile, outputStream);
			outputStream.close();
			System.out.println("Source FTP file Result:" + success);

			if (success) {

				// Modify Epub // Create cover //Generate ISBN
				String isbn  = ISBN.getID(id);
				GutenbergProduct gutenbergProduct = EpubModifier.updateEpub(tmpPath, fileName,isbn);
				if(gutenbergProduct!=null){
				
				String onixFile = isbn + ".xml";
				String tmpOnixFile = tmpPath + onixFile;
				OnixGenerator onixGenerator = new OnixGenerator();
				onixGenerator.generateOnix(id,isbn, gutenbergProduct.getTitle(), gutenbergProduct.getSubTitle(),gutenbergProduct.getAuthor(), gutenbergProduct.getDescription(), gutenbergProduct.getSubjects(),tmpOnixFile);
				String epubFile = isbn + ".epub";
				String coverFile = isbn + ".jpg";
				String tmpEpubFile = tmpPath + epubFile;
				String tmpCoverFile = tmpPath + coverFile;
				
				String destPath = "/gutenberg/" + isbn + "/";
				String destEpubFile = destPath + "/" + epubFile;
				String destCoverFile = destPath + "/" + coverFile;
				String destOnixFile = destPath + "/" + onixFile;

				File tmpEpubObject = new File(tmpEpubFile);
				File tmpCoverObject = new File(tmpCoverFile);
				File tmpOnixObject = new File(tmpOnixFile);

				/*destftpClient.connect(toServer, port);
				destftpClient.login(destUser, destPass);
				// ftpClient.enterLocalActiveMode();
				destftpClient.enterLocalPassiveMode();
				destftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				destftpClient.makeDirectory(destPath);
				destftpClient.changeWorkingDirectory(destPath);
				// this overwrites the existing file
				InputStream input = new FileInputStream(tmpEpubFile);
				destftpClient.storeFile(epubFile, input);
				input.close();
				input = new FileInputStream(tmpCoverFile);
				destftpClient.storeFile(coverFile, input);
				input.close();
				input = new FileInputStream(tmpOnixFile);
				destftpClient.storeFile(onixFile, input);
				input.close();*/
				System.out.println("Temp File: " + tmpEpubFile + "Destination Epub :" + destEpubFile);
				}
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {

			//tmpFileObject.delete();
			try {
				if (srcftpClient.isConnected()) {
					srcftpClient.logout();
					srcftpClient.disconnect();
				}
				if (destftpClient.isConnected()) {
					destftpClient.logout();
					destftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("FTP FILE  STATUS :" + success);
		if (success) {

			System.out.println("Source File :" + srcFile);
		}
	}

	public static void main(String[] args) {
		for (int i = 10; i <= 12; i++) {
			try{
				copyEpubFile(i);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
	}

}
