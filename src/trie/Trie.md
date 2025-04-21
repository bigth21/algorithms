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
- Time Complexity: $O(n)$, where $n$ is the length of string. Each character is processed once to either traverse or create a node.
### 2. Search
- Similar to insertion, traverse the Trie following the nodes for each character in the search string.
- Return true if the entire string is found and the last node is marked as an "end of word".
- Time Complexity: $O(n)$, where $n$ is the length of the string. Each character is processed once while traversing the Trie.
### 3. Prefix Match:
- Tries are particularly efficient to check for string starting with a given prefix. Simply search for the prefix in the Trie, and if it exist, all its descendants from valid strings with that prefix.
- Time Complexity: $O(n)$, where $n$ is the length of the prefix. we only need to traverse nodes corresponding to the characters in the prefix.
### 4. Deletion:
- To delete a string, navigate to the end of the string's path and remove the "end of word" marker.
- If the node has no children, prune unnecessary nodes to free memory.
- Time Complexity: $O(n)$, where $n$ is the length of the string. The traverse to find the word or prune unused nodes takes linear time relative to the word length.
## Advantages of Trie
### 1. Efficient Search:
- Searching for string or prefix is faster than many other structures (like hashes or arrays), Taking $O(n)$Times, where $n$ is the length of the string.
### 2. Shared Prefix:
- Reduces space usage by storing common prefixes only once.
### 3. Autocomplete and Prefix Matching:
- Well-suited for applications like **autocomplete**, **spell-checking** and **prefix-based text searching**.
### 4. Sorted Order:
- By traversing the Trie, strings can be retrieved in lexicographical order without additional sorting
## Disadvantages of Trie:
### 1. Space Complexity
- For sparse data or a large number of characters (like Unicode), the Trie can consume a lot of memory since each node might have multiple children.
### 2. Implementation Complexity
- Managing and maintaining Tries can be more complex compared to simpler data structure like arrays or hash maps.
## Applications:
### 1. Autocomplete Systems:
- Quickly suggest words based on user input (e.g., search engines, mobile keyboards).
### 2. Spell Checker:
- Verify if a word exists in a dictionary.
### 3. IP Routing:
- Efficient lookup for prefix-based matching of IP addresses.
### 4. Genome Analysis:
- Storing DNA sequences for pattern matching.
### 5. Data Compression
- Represent common prefixes or repeated patterns compactly.