JCC=javac
JFLAGS=-g

default:b_plus_tree.class key_node_map.class index_node.class leaf_node.class node.class treesearch.class

b_plus_tree.class:b_plus_tree.java
	$(JCC) $(JFLAGS) b_plus_tree.java

key_node_map.class:key_node_map.java
	$(JCC) $(JFLAGS) key_node_map.java

index_node.class:index_node.java
	$(JCC) $(JFLAGS) index_node.java

leaf_node.class:leaf_node.java
	$(JCC) $(JFLAGS) leaf_node.java

node.class:node.java
	$(JCC) $(JFLAGS) BPlusTree.java

treesearch.class:treesearch.java
	$(JCC) $(JFLAGS) treesearch.java

clean:
	${RM} *.class
