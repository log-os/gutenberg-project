/**
 * @author naresh
 */
package social.logos.epubmaker.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.domain.Resources;
import nl.siegmann.epublib.epub.EpubReader;
import nl.siegmann.epublib.epub.EpubWriter;
import onix.social.logos.GutenbergProduct;

/**
 * @author naresh
 *
 */
public class EpubModifier {

    public static Font ProximaFont;
    public static List<Color> colors = new ArrayList<Color>();

    public final static int START = 0;
    public final static int END = 1;
    public final static int NEXT = 2;

    public static boolean isStart = false;
    public static boolean isEnd = false;

    public static String startLicenceList[] = {"start of this project gutenberg", "start of the project gutenberg"};
    public static String nextList[] = {"produced by", "edition by", "An Anonymous", "prepared by"};
    public static String endLicenceList[] = {"end of the project gutenberg", "end of project gutenberg",
            "end of this project gutenberg"};
    public static Color titleColor = new Color(48, 64, 59);

    static {

        colors.add(new Color(0, 164, 138));
        colors.add(new Color(179, 155, 134));
        colors.add(new Color(146, 201, 185));
        colors.add(new Color(231, 228, 90));
        colors.add(new Color(244, 237, 174));
        colors.add(new Color(206, 224, 172));
        colors.add(new Color(231, 215, 193));
        Font font = null;

        String fName = "/ProximaNova-Semibold.otf";
        try {
            InputStream is = EpubModifier.class.getResourceAsStream(fName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(fName + " not loaded.  Using serif font.");
            font = new Font("serif", Font.PLAIN, 24);
        }
        ProximaFont = font;

    }

    public static void main(String a[]) {

    }

    public static void saveCover(InputStream inputStream, String coverPath) {

        OutputStream outputStream = null;

        try {
            // read this file into InputStream

            // write the inputStream to a FileOutputStream
            outputStream = new FileOutputStream(new File(coverPath));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            System.out.println("Done!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void title2Cover(String title, String author, String coverPath) {
        title = title.toUpperCase();
        author = author.toUpperCase();
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2d = image.createGraphics();
        Font defaultFont = graphics2d.getFont();
        Font titleFont = ProximaFont.deriveFont(35f);
        Font authorFont = ProximaFont.deriveFont(25f);
        System.out.println("Font Name :" + authorFont.getFontName());
        int width = 600;// fontmetrics.stringWidth(text);
        int height = 800;// fontmetrics.getHeight();
        graphics2d.setFont(titleFont);
        FontMetrics fontmetrics = graphics2d.getFontMetrics();
        int singleCharSize = fontmetrics.stringWidth("A");
        int charHeight = fontmetrics.getHeight() + 30;
        int maxCharsInline = ((width) / singleCharSize);
        int stringWidth = fontmetrics.stringWidth(title);
        graphics2d.dispose();

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics2d = image.createGraphics();
        Random rand = new Random();
        int randomColor = rand.nextInt(colors.size() - 1);
        graphics2d.setColor(colors.get(randomColor));
        graphics2d.fillRect(0, 0, width, 550);
        graphics2d.setColor(new Color(48, 64, 59));
        graphics2d.fillRect(0, 550, width, 250);
        fontmetrics = graphics2d.getFontMetrics();
        if (randomColor <= 1) {
            graphics2d.setColor(Color.WHITE);
        } else {
            graphics2d.setColor(titleColor);
        }
        graphics2d.setFont(titleFont);
        int canDisplay = graphics2d.getFont().canDisplayUpTo(title);

        System.out.println("Can Display:" + canDisplay);
        if (canDisplay != -1) {
            System.out.println("TitleFont:" + defaultFont.getFamily());
            graphics2d.setFont(new Font(defaultFont.getFamily(), defaultFont.getStyle(), 35));
        }
        fontmetrics = graphics2d.getFontMetrics();
        if (stringWidth < width - 50) {
            System.out.print("Title :" + title);
            graphics2d.drawString(title, (width / 2) - (stringWidth / 2), 150);
        } else {
            String[] titletext = title.split(" ");
            List<String> titleWords = new ArrayList<String>();
            titleWords.add(titletext[0]);
            int totalWords = titletext.length;
            int currentLine = 0;
            for (int currentWord = 0; currentWord < totalWords; ) {
                String currentLineText = titletext[currentWord];
                while (currentWord < (totalWords - 1)
                        && (currentLineText.length() + titletext[currentWord + 1].length()) < maxCharsInline) {
                    currentLineText += " " + titletext[currentWord + 1];
                    currentWord++;
                }
                System.out.println("Current Line :" + currentLineText);

                graphics2d.drawString(currentLineText, ((width / 2) - (fontmetrics.stringWidth(currentLineText) / 2)),
                        150 + (currentLine * charHeight));
                currentWord++;
                currentLine++;
            }

        }
        graphics2d.setFont(authorFont);
        graphics2d.setColor(Color.WHITE);
        fontmetrics = graphics2d.getFontMetrics();
        int authorWidth = fontmetrics.stringWidth(author);
        graphics2d.drawString(author, (width / 2) - (authorWidth / 2), 650);

        graphics2d.dispose();
        try {
            ImageIO.write(image, "png", new File(coverPath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

	/*
     * public static void getJSONSpine(Spine resource) { // Object mapper
	 * instance Gson gson = new Gson();
	 * 
	 * System.out.println(gson.toJson(resource)); }
	 * 
	 * public static void getJSONManifest(Guide resource) { // Object mapper
	 * instance Gson gson = new Gson();
	 * 
	 * System.out.println(gson.toJson(resource)); }
	 * 
	 * public static void printBook(Book book) { Gson gson = new Gson();
	 * 
	 * System.out.println(gson.toJson(book)); }
	 * 
	 * public static void printToc(TableOfContents toc) { Gson gson = new
	 * Gson();
	 * 
	 * System.out.println(gson.toJson(toc));
	 * 
	 * }
	 */

    public static String getDataInPage(String page) {
        // System.out.println("Page :"+page);
        Document doc = Jsoup.parse(page);

        List<Element> elementList = new ArrayList<>();

        for (int i = 0; i < doc.select("body>*").size(); i++) {

            Element element = doc.select("body>*").get(i);

            if (isLicenceMatch(element.outerHtml().toLowerCase(), START)) {
                System.out.println("Found Start Element :" + element.outerHtml().toLowerCase());
                elementList.add(element);

                List<Node> nodeList = null;

                try {
                    nodeList = removeSubling(element);

                } catch (Exception ex) {
                }

                for (Element elementListItem : elementList) {
                    elementListItem.remove();
                }

                if (nodeList != null) {

                    for (Node node : nodeList)
                        if (node != null)
                            node.remove();
                }

                isStart = true;

                break;
            } else {
                // System.out.println("Element
                // :"+element.outerHtml().toLowerCase());
                // element.remove();
                elementList.add(element);
            }
        }
        boolean foundEnd = false;
        for (Element element : doc.select("body>*")) {

            if (isLicenceMatch(element.outerHtml().toLowerCase(), END)) {
                foundEnd = true;
                System.out.println("Found End Element :" + foundEnd + element.outerHtml());
                element.remove();

                isEnd = true;

            } else {
                if (foundEnd) {
                    System.out.println("Element :" + foundEnd + element.outerHtml().toLowerCase());
                    element.remove();
                }
            }
        }

        return doc.outerHtml();
    }

    public static List<Node> removeSubling(Element element) throws Exception {

        List<Node> nodeList = new ArrayList<>();

        Node node = element.nextSibling();
        if (node != null) {
            if (isLicenceMatch(node.outerHtml().toLowerCase(), NEXT)) {
                nodeList.add(node);
            }

            Node node2 = node.nextSibling();
            if (isLicenceMatch(node2.outerHtml().toLowerCase(), NEXT)) {
                nodeList.add(node2);
            }

            Node node3 = node2.nextSibling();
            if (isLicenceMatch(node3.outerHtml().toLowerCase(), NEXT)) {
                nodeList.add(node3);
            }

        }

        return nodeList;

    }

    public static boolean isLicenceMatch(String string, int condition) {
        boolean isMatch = false;

        switch (condition) {

            case START:
                for (String str : startLicenceList) {
                    if (string.contains(str)) {
                        isMatch = true;
                        break;
                    }
                }
                break;

            case END:
                for (String str : endLicenceList) {
                    if (string.contains(str)) {
                        isMatch = true;
                        break;
                    }
                }
                break;

            case NEXT:
                for (String str : nextList) {
                    if (string.contains(str)) {
                        isMatch = true;
                        break;
                    }
                }
                break;

        }

        return isMatch;
    }

    public static GutenbergProduct updateEpub(String oldPath, String fileName, String isbn) {
        Book book;
        EpubReader epubReader = new EpubReader();
        GutenbergProduct gutenbergProduct = new GutenbergProduct();

        try {
            book = epubReader.readEpub(new FileInputStream(oldPath + "/" + fileName));
            // printBook(book);
			/*
			 * printToc(book.getTableOfContents()); Reader reader =
			 * book.getNcxResource().getReader();
			 */

            gutenbergProduct.setIsbn(isbn);
            String author = "";
            if (!book.getMetadata().getAuthors().isEmpty()) {
                if (book.getMetadata().getAuthors().get(0).getFirstname() != null) {
                    author += book.getMetadata().getAuthors().get(0).getFirstname();
                }
                if (book.getMetadata().getAuthors().get(0).getLastname() != null) {
                    author += " " + book.getMetadata().getAuthors().get(0).getLastname();
                }
                gutenbergProduct.setAuthor(author);
            }

			/*
			 * getJSONSpine(book.getSpine()); getJSONManifest(book.getGuide());
			 */
            if (!book.getMetadata().getDescriptions().isEmpty()) {

                // gutenbergProduct.setDescription();
                for (String description : book.getMetadata().getDescriptions()) {
                    System.out.println("Description :" + description);
                }
            }

            if (!book.getMetadata().getTitles().isEmpty()) {
                if (book.getMetadata().getTitles().get(0) != null) {
                    String titles = book.getMetadata().getTitles().get(0);
                    int index = titles.indexOf("/");
                    System.out.print(index);
                    if (index > 0) {
                        String title = titles.substring(0, index);
                        gutenbergProduct.setTitle(title);
                        if (index + 1 < titles.length()) {
                            String subTitle = titles.substring(index + 1, titles.length());
                            gutenbergProduct.setSubTitle(subTitle);
                        }

                    } else {
                        gutenbergProduct.setTitle(titles);
                    }

                }

            } else {
                return null;
            }

            if (!book.getMetadata().getSubjects().isEmpty()) {
                gutenbergProduct.setSubjects(book.getMetadata().getSubjects());
            }

            removeLicense(book, oldPath, oldPath, fileName, isbn);

            if (EpubModifier.isStart != true || EpubModifier.isEnd != true) {

                return null;
            }

            Resource cover = book.getCoverImage();
            if (cover != null) {
                InputStream is = cover.getInputStream();
                saveCover(is, oldPath + "/" + isbn + ".jpg");
            } else {
                title2Cover(gutenbergProduct.getTitle(), gutenbergProduct.getAuthor(), oldPath + "/" + isbn + ".jpg");
            }

            String language = book.getMetadata().getLanguage();
            if (language != null && !language.equals("")) {
                gutenbergProduct.setLanguage(book.getMetadata().getLanguage());
            }
            return gutenbergProduct;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void removeLicense(Book book, String oldDirectory, String newDirectory, String filename,
                                     String isbn) {

        try {

            List<Resource> contents = book.getContents();
            Resources resources = book.getResources();
            List<Resource> possiblePages = new ArrayList<Resource>();
            int maxIndex = contents.size() - 1;
            for (int i = 0; i < 2 && i <= maxIndex; i++) {
                possiblePages.add(contents.get(i));
                possiblePages.add(contents.get(maxIndex - i));
            }
            for (Resource chapter : possiblePages) {

                BufferedReader reader = new BufferedReader(chapter.getReader());
                StringBuilder out = new StringBuilder();
                int value = 0;
                while ((value = reader.read()) != -1) {

                    // converts int to character
                    char c = (char) value;
                    out.append(c);

                }


                boolean contentModified = false;
                String data = getDataInPage(out.toString());
                contentModified = true;
				/*
				 * while ((line = reader.readLine()) != null) { if
				 * (!(line.contains("Gutenberg") || line.contains("GUTENBERG")
				 * || line.contains("gutenberg") || line.contains("Gutenberg")
				 * || line.contains("pgheader") || line.contains("pglaf"))) { //
				 * System.out.println("" + line); out.append(line); } else {
				 * contentModified = true; System.out.println("Remove :" +
				 * line); }
				 * 
				 * }
				 */

                if (contentModified) {

                    chapter.setData(data.getBytes());
                    if (resources.containsByHref(chapter.getHref())) {
                        resources.add(chapter);
                    }
                }
                reader.close();

            }

            book.setResources(resources);

            EpubWriter writer = new EpubWriter();
            writer.write(book, new FileOutputStream(newDirectory + "/" + isbn + ".epub"));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}