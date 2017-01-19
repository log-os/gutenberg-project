/**
 * @author naresh
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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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

	public static List<Integer> idList = new ArrayList<Integer>();

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
		String destUser = "gutenberg";
		String destPass = "#tNF*v#2XIoU87Kg1G";

		FTPClient srcftpClient = new FTPClient();
		FTPClient destftpClient = new FTPClient();
		boolean success = false;
		String srcPath = "/mirrors/gutenberg/cache/epub/" + id + "/";
		String srcFile = srcPath + fileName;
		String tmpPath = "/opt/logos/dropbox/tmp/gutenberg/" + id + "/";
		String tmpFile = tmpPath + fileName;

		File tmpFileObject = new File(tmpFile);
		File tmpEpubObject = null;
		File tmpCoverObject = null;
		File tmpOnixObject = null;
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
				String isbn = ISBN.getID(id);
				GutenbergProduct gutenbergProduct = EpubModifier.updateEpub(tmpPath, fileName, isbn);

				if (gutenbergProduct != null) {

					String onixFile = isbn + ".xml";
					String tmpOnixFile = tmpPath + onixFile;
					OnixGenerator onixGenerator = new OnixGenerator();
					onixGenerator.generateOnix(id, isbn, gutenbergProduct.getTitle(), gutenbergProduct.getSubTitle(),
							gutenbergProduct.getAuthor(), gutenbergProduct.getDescription(),
							gutenbergProduct.getSubjects(), tmpOnixFile);
					String epubFile = isbn + ".epub";
					String coverFile = isbn + ".jpg";
					String tmpEpubFile = tmpPath + epubFile;
					String tmpCoverFile = tmpPath + coverFile;

					String destPath = "/gutenberg/" + isbn + "/";
					String destEpubFile = destPath + "/" + epubFile;
					String destCoverFile = destPath + "/" + coverFile;
					String destOnixFile = destPath + "/" + onixFile;

					tmpEpubObject = new File(tmpEpubFile);
					tmpCoverObject = new File(tmpCoverFile);
					tmpOnixObject = new File(tmpOnixFile);

					
					  destftpClient.connect(toServer, port);
					  destftpClient.login(destUser, destPass); //
					  destftpClient.enterLocalPassiveMode();
					  destftpClient.setFileType(FTP.BINARY_FILE_TYPE);
					  destftpClient.makeDirectory(destPath);
					  destftpClient.changeWorkingDirectory(destPath); // this
					  //overwrites the existing file 
					  InputStream input = new
					  FileInputStream(tmpEpubFile);
					  destftpClient.storeFile(epubFile, input); input.close();
					  input = new FileInputStream(tmpCoverFile);
					  destftpClient.storeFile(coverFile, input); input.close();
					  input = new FileInputStream(tmpOnixFile);
					  destftpClient.storeFile(onixFile, input); input.close();
					 
					System.out.println("Temp File: " + tmpEpubFile + "Destination Epub :" + destEpubFile);
				} else {
					idList.add(id);
				}
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (tmpFileObject != null && tmpFileObject.exists()) {
				tmpFileObject.delete();
			}
			if (tmpEpubObject != null && tmpEpubObject.exists()) {
				tmpEpubObject.delete();
			}
			if (tmpCoverObject != null && tmpCoverObject.exists()) {
				tmpCoverObject.delete();
			}
			if (tmpOnixObject != null && tmpOnixObject.exists()) {
				tmpOnixObject.delete();
			}
			System.out.println("Encoding :"+System.getProperty("file.encoding"));
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
		System.setProperty("file.encoding", "UTF-8");
        System.out.println("Encoding :"+System.getProperty("file.encoding"));
		System.out.println("Charset :"+Charset.defaultCharset());	
		for (int i = 23950; i <= 23950; i++) {
			try {

				EpubModifier.isStart = false;
				EpubModifier.isEnd = false;

				copyEpubFile(i);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

		System.out.print("FAILURE----[");
		for (Integer id : idList) {
			System.out.print(id + ",");
		}
		System.out.print("]");

		idList.clear();

	}

}