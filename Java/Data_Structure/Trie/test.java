
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Trie trie = new Trie();
	        trie.insertWord("car");
	        trie.insertWord("card");
	        trie.insertWord("chip");
	        trie.insertWord("trie");
			trie.insertWord("try");
			System.out.println(trie.isPrefixValid("h"));
			
	        // trie.printkeys(trie);
	}

}
