
Toy Store Inventory Management System
Overview
This Java-based Toy Store Inventory Management System is a comprehensive application designed to streamline the inventory management process for a toy store. The system offers a feature-rich graphical user interface (GUI) and leverages object-oriented principles for effective toy categorization and organization. It incorporates key features such as adding, removing, and viewing toys, catering to various types like Figures, Animals, Puzzles, and Board Games.

Features
1. Adding Toys
Figures: Inclusion of action figures with detailed attributes such as Serial Number, Name, Brand, Price, Stock, Age Restriction, and Classification.

Animals: Management of toy animals featuring details like Serial Number, Name, Brand, Price, Stock, Age Restriction, and Size.

Puzzles: Integration of puzzles into the inventory system, specifying attributes like Serial Number, Name, Brand, Price, Stock, Age Restriction, and Puzzle Type.

Board Games: Handling board games, providing information such as Serial Number, Name, Brand, Price, Stock, Age Restriction, Range of Players, and Developers.

2. Removing Toys
The system allows users to search for toys by Serial Number and efficiently remove them from the inventory.
3. Viewing Inventory
The application provides a user-friendly interface for easily viewing the entire inventory, categorized by different toy types.
4. Graphical User Interface (GUI) Navigation
The GUI includes a toolbar with buttons for seamless navigation between the main, add, and remove screens.
5. Unit Testing
The project incorporates JUnit tests to ensure the reliability and functionality of critical components.
6. Logging
Logging mechanisms are implemented to track important events and potential issues within the system, enhancing overall maintainability.
Classes
1. Toy Class
Represents a fundamental toy with common attributes, serving as an abstract class for specific toy types.
2. Figures, Animals, Puzzles, Board Games Classes
Each class extends the Toy class, encapsulating unique attributes and functionalities for their respective toy categories.
Technologies Used
JavaFX: The GUI is built using JavaFX, providing a modern and interactive user interface.

JUnit: Unit testing framework for validating the correctness of the code.

Logging Framework: Utilizes a logging framework to capture and manage system logs for debugging and analysis.
