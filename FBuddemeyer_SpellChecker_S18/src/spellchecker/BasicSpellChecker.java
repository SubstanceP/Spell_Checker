package spellchecker;

import static sbcc.Core.*;

import java.util.*;
import java.util.regex.*;

public class BasicSpellChecker implements SpellChecker {

	BasicDictionary dictionary = new BasicDictionary();

	StringBuilder sb;

	String expr = "<[^<>]+>";
	Pattern p = Pattern.compile(expr);
	// String text = readFile(xmlDocument);
	Matcher matcher;


	@Override
	public void importDictionary(String filename) throws Exception {
		dictionary.importFile(filename);

	}


	@Override
	public void loadDictionary(String filename) throws Exception {
		dictionary.load(filename);
	}


	@Override
	public void saveDictionary(String filename) throws Exception {
		dictionary.save(filename);
	}


	@Override
	public void loadDocument(String filename) throws Exception {
		String contents = readFile(filename);
		sb = new StringBuilder(contents);
		matcher = Pattern.compile("\\b[\\w']+\\b").matcher(contents);
	}


	@Override
	public void saveDocument(String filename) throws Exception {
		String save = sb.toString();
		writeFile(filename, save);

	}


	@Override
	public String getText() {
		return sb.toString();
	}


	@Override
	public String[] spellCheck(boolean continueFromPrevious) {
		// \\b[\w']+\\b
		// if mather you do
		// if the matcher is null, or, if not continue from previous

		// Matcher m = p.matcher();
		// String match = matcher.group();
		if (!continueFromPrevious) {
			matcher.reset(sb);
		}
		while (matcher.find()) {
			// set a match found variable
			String matchWord = matcher.group();

			// creat an array dictionary find function
			String[] similarWords = dictionary.find(matchWord);

			if (similarWords != null) {
				// returns an array from comparing similar words to the target word
				return new String[] { matchWord, Integer.toString(matcher.start()), similarWords[0], similarWords[1] };
			}
		}

		return null;
	}


	@Override
	public void addWordToDictionary(String word) {
		dictionary.add(word);
	}


	@Override
	public void replaceText(int startIndex, int endIndex, String replacementText) {
		sb.replace(startIndex, endIndex, replacementText);
		matcher.reset(sb);

	}

}
