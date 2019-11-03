import java.util.*;

public class Trie {
	 public Node root;
	    
	    public Trie() {
	        this.root = new Node();
	    }
	    
	    public void insertWord(String word) {
	        Node currentNode = this.root;
	        for(int i = 0; i < word.length(); i++) {
	            Character currentLetter = word.charAt(i);
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
			for(int i = 0; i < 1; i++) {
				Character currentLetter1 = prefix.charAt(i);
				Node child1 = currentNode1.children.get(currentLetter1);
					if(child1 == null){
						return false;
					}	
					currentNode1 = 	child1;
			}
			return true;
		}
	
	boolean isWordValid(String word){
			Node currentNode1 = this.root;
			for(int i = 0; i < word.length(); i++) {
				Character currentLetter1 = word.charAt(i);
				Node child1 = currentNode1.children.get(currentLetter1);
					if(child1 == null){
						return false;
					}	
					currentNode1 = 	child1;
			}
			return true;
		}

		

	    public void printkeys () {
		
	    	Set <Character> keys = this.root.children.keySet();
	    			for ( Character key : keys) {
						System.out.println(key);
			
					}			
	    }
	    }
