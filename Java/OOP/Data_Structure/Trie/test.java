
public class test {

	public static void main(String[] args) {
		   Trie trie = new Trie();
	        trie.insertWord("car");
	        trie.insertWord("card");
	        trie.insertWord("chip");
	        trie.insertWord("trie");
			trie.insertWord("try");
			System.out.println(trie.isPrefixValid("c"));
			System.out.println(trie.isWordValid("try"));
	        trie.printkeys();
	}

}
