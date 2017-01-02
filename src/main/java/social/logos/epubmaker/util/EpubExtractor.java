/**
 * 
 */
package social.logos.epubmaker.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author naresh
 *
 */
public class EpubExtractor {
	
	public static void main(String a[]){
		try {
			unzip("/opt/logos/dropbox/tmp/gutenberg/1/LO00000000001.epub","/opt/logos/dropbox/tmp/gutenberg/1/");
			//unzip("/Users/naresh/dev/epub/pg53008-images.epub","/Users/naresh/dev/epub/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// TODO: more efficient unzipping
		public static void unzip(String inputZip, String destinationDirectory) throws IOException {
			int BUFFER = 2048;
			List zipFiles = new ArrayList();
			File sourceZipFile = new File(inputZip);
			File unzipDestinationDirectory = new File(destinationDirectory);
			unzipDestinationDirectory.mkdir();

			ZipFile zipFile;
			zipFile = new ZipFile(sourceZipFile, ZipFile.OPEN_READ);
			Enumeration zipFileEntries = zipFile.entries();

			// Process each entry
			while (zipFileEntries.hasMoreElements()) {

				ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
				String currentEntry = entry.getName();
				File destFile = new File(unzipDestinationDirectory, currentEntry);

				if (currentEntry.endsWith("zip")) {
					zipFiles.add(destFile.getAbsolutePath());
				}

				File destinationParent = destFile.getParentFile();
				destinationParent.mkdirs();

				if (!entry.isDirectory()) {
					BufferedInputStream is = new BufferedInputStream(zipFile.getInputStream(entry));
					int currentByte;
					// buffer for writing file
					byte data[] = new byte[BUFFER];

					FileOutputStream fos = new FileOutputStream(destFile);
					BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);

					while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
						dest.write(data, 0, currentByte);
					}
					dest.flush();
					dest.close();
					is.close();

				}

			}
			zipFile.close();

			for (Iterator iter = zipFiles.iterator(); iter.hasNext();) {
				String zipName = (String) iter.next();
				unzip(zipName,
						destinationDirectory + File.separatorChar + zipName.substring(0, zipName.lastIndexOf("zip")));
			}
		}
		

}
