
/**
 * {@index} OddWords
 * 
 * {@author lukeponga}
 */

import java.io.FileReader;
import java.io.BufferedReader;

public class OddWords {
	public static void main(String[] args) {
		if (args.length != 1) // if no file entered
		{
			System.err.println("Usage: java OddWords <Filename>");
			return;
		}
	}

	public void processFile(String args) {
		BinarySearchTree oddWords = new BinarySearchTree();

		try {
			BufferedReader br = new BufferedReader(new FileReader(args)); // file reader
			String s = br.readLine(); // read first line
			while (s != null) // while file is not read
			{
				String[] line = s.split("\\W+");// grab alpha character
				for (String t : line) {
					String c = t.toLowerCase();// convert to lowercase
					if (c.equals(oddWords.search(s)) == true) // if already in BST
					{
						oddWords.remove(c); // remove it
						System.out.println(c + " DELETED");
					} else // if not
					{
						oddWords.insert(c); // insert it

						System.out.println(c + " INSERTED");
					}
				}
				s = br.readLine(); // read next line
			}
			oddWords.dump(); // print contents of BST
			System.out.println("");
			System.out.println();
			br.close();
		} catch (Exception e) {
			System.out.println("Error Encountered: ");
			e.printStackTrace();
		}

	}
}
