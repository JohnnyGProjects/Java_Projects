# 20 Questions Game (Java – Swing)

## Overview
This project is a Java-based implementation of the classic **20 Questions** guessing game using a **binary decision tree**.  
The program interacts with the user through dialog boxes (Swing) and improves its guessing ability over time by learning from incorrect guesses.

The game starts with a small built-in knowledge base and dynamically expands as the user teaches it new distinctions.

---

## 🎮 How the Game Works
1. The program asks the user to think of a **living or non-living thing**.
2. It asks a sequence of **yes/no questions** to narrow down the guess.
3. If the program guesses correctly, the round ends.
4. If it guesses incorrectly:
   - The user provides the correct answer.
   - The user provides a **yes/no question** that distinguishes the new item from the incorrect guess.
   - The decision tree is updated with this new knowledge.
5. At the end of the session, the user can choose to **save the learned knowledge to a file**.

---

## 📁 Project Structure

### `A4P2GebreYoseph.java`
- Contains the `main` method.
- Controls the overall flow of the game.
- Manages game rounds and user prompts.
- Handles saving learned knowledge when the game ends.

---

### `DTNode.java`
- Represents a node in the decision tree.
- Each node contains:
  - A question or guess (`item`)
  - A `yes` branch (`left`)
  - A `no` branch (`right`)
- Includes a method to determine whether a node is a **leaf**.

---

### `Questioner.java`
- Core logic of the game.
- Builds the initial decision tree.
- Traverses the tree based on user responses.
- Updates the tree when the program guesses incorrectly.
- Handles saving and loading the tree from a file using **preorder traversal**.

---

## 🌳 Decision Tree Design
- **Internal nodes** store yes/no questions.
- **Leaf nodes** store final guesses.
- User responses guide traversal:
  - **Yes → left child**
  - **No → right child**
- When the program learns something new, it replaces a leaf node with a new question node.

---

## 💾 File Persistence
- The decision tree can be **saved to a file** using preorder traversal.
- The tree can later be **reloaded**, allowing the game to retain knowledge between runs.
- File selection is handled using `JFileChooser`.

---

## 🛠 Technologies Used
- Java
- Swing (`JOptionPane`, `JFileChooser`)
- File I/O (`FileReader`, `FileWriter`, `PrintWriter`)
- Recursion
- Binary trees

---

## ▶️ How to Run
1. Compile all `.java` files:
   ```bash
   javac *.java

Run the main class:

java A4P2GebreYoseph


Follow the on-screen dialog prompts.

🎯 Learning Objectives

This project demonstrates:

Object-oriented programming

Tree-based data structures

Recursion

User interaction with Swing

File input/output

Dynamic program behavior through learning

👨‍💻 Author

Johnny (Yoseph Gebre)

📌 Notes

The game improves only if the user chooses to save the updated tree.

All interaction occurs through dialog boxes (no console input).
