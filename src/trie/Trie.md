# Trie (Prefix Tree)
A Trie, or Prefix Tree, is a tree-like data structure used to efficiently store and strings,  particularly useful with large sets of strings, such as dictionary words or sequences. It is commonly referred to as a **prefix tree** because it organizes strings by their prefixes.
## Characteristics
### 1. Node Structure:
- Each node in Trie represents a single character or part of string.
- A node can have multiple children, each representing different possible characters that follow in the sequence.
### 2. Root Node:
- The root node of a Trie is empty(it represents no character).
- From the root, paths are created for each character of a string.
### 3. End of Word Marker:
- Trie nodes often include a flag or marker to indicate whether they represent the end of a valid string (word).
### 4. Space Efficiency:
- Instead of storing strings separately in their entirety, common prefixes are stored only once, reducing redundant storage.
### 5. Alphabetical Representation:
- Each level of the Trie corresponds to a position in the string, and children nodes represent possible next characters.
## Operations on a Trie:
### 1. Insertion:
- To insert a string, start from the root and create nodes corresponding to each character in the string.
- Mark the last node in the path as the "end of word".
### 2. Search
- Similar to insertion, traverse the Trie following the nodes for each character in the search string.
- Return true if the entire string is found and the last node is marked as an "end of word".
### 3. Prefix Match:
- Tries are particularly efficient to check for string starting with a given prefix. Simply search for the prefix in the Trie, and if it exist, all its descendants from valid strings with that prefix.
### 4. Deletion
- To delete a string, navigate to the end of the string's path and remove the "end of word" marker.
- If the node has no children, prune unnecessary nodes to free memory. 