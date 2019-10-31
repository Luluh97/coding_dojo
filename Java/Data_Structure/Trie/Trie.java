import java.util.*;

public class Trie {
	 public Node root;
	    
	    public Trie() {
	        this.root = new Node();
	    }
	    
	    public void insertWord(String word) {
	        // gets the root node;
	        Node currentNode = this.root;
	        
	        // iterates over every character in the word
	        for(int i = 0; i < word.length(); i++) {
	            // currentLetter is just the character / letter at the iteration
	            Character currentLetter = word.charAt(i);
	            // ask if the current letter is in the map of the current node
				Node child = currentNode.children.get(currentLetter);
	            if(child == null) {
	                child = new Node();
	                currentNode.children.put(currentLetter, child); 
	            } 
	            
	            currentNode = child;
	        }
	        currentNode.isCompleteWord = true;
		}
		
	boolean isPrefixValid(String prefix){
			Node currentNode1 = this.root;
			for(int i = 0; i < prefix.length(); i++) {
				Character currentLetter1 = prefix.charAt(i);
				Node child1 = currentNode1.children.get(currentLetter1);
					if(child1 == null){
						return false;
					}		
			}
			return true;
		}

		

	    // public void printkeys (Trie t) {
	    // 	Set <Character> keys = t.root.children.keySet();
	    // 			for ( Character key : keys) {
		// 				System.out.println(key);
		// 				Set <Character> keys1 = t.root.children.get(key).children.keySet();
		// 				System.out.println("others..."+key1);

	    				
	    // 			}
	    	
	    // }
	    }
