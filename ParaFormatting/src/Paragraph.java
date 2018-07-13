
public class Paragraph {
	private String words;

	public Paragraph() {
		this.words = "";
	}

	public void addWords(String moreWords) {
		this.words += moreWords;
	}

	public String format(ParaStyle ps) {
		if (ps == null)
			return words + "\n";

		String firstLineIndent = "";
		String indent = "";
		int lineLength = ps.getLineLength();
		String[] tokens;
		String pageText = "";
		String line;

		for (int i = 0; i < ps.getLeftIndent(); i++)
			indent += " ";

		for (int i = 0; i < (ps.getLeftIndent() + ps.getFirstLineAdjustment()); i++)
			firstLineIndent += " ";

		tokens = words.split(" ");
		if (tokens.length == 0)
			return "\n";

		line = firstLineIndent + tokens[0];// assuming that line length will be
											// always greater than
											// firstLineIndent + tokens[0]

		for (int i = 1; i < tokens.length; ++i) {
			if ((line.length() + tokens[i].length() + 1) <= lineLength)
				line += (" " + tokens[i]);
			else {
				pageText += (line + "\n");
				line = indent + tokens[i];

			}
		}

		pageText += (line + "\n");
		return pageText;

	}
}
