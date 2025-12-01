# Sales Analysis Application
This project is a Java-based application designed to track and analyze sales data for a franchise. It reads daily sales figures from a text file for multiple stores, processes five weeks of data, and calculates key performance metrics such as total sales, average sales, and highest/lowest performing weeks. The system utilizes a console-based interface for user interaction.

## Component Architecture
The system is broken down into 4 classes:

`FileIO`

This class handles file input and data parsing
  - **Variables**: Stores the necessary variables for reading and parsing files (path, tokenizer, etc.)
  - **Functionality**:
    - Reads from a specific file (e.g., `salesdata.txt`) using `FileReader` and `BufferedReader`
    - Parses the file structure: reads the number of stores to instantiate the `Franchise` object, ignores the header line, and parses subsequent lines to populate `Store` objects
    - Includes a debug mode to verify data reading accuracy

`Franchise`

This class acts as the container for all `Store` objects
  - **Variables**: Stores a private array of `Store` objects
  - **Functionality**:
    - Provides a `calc()` method that triggers the analysis and calculation of results for every store in the franchise
    - Includes methods to retrieve specific stores and print the total number of stores

`Store`

This class represents a single store and handles its specific data analysis
  - **Variables**: Uses a floating-point array (`salesbyweek[][]`) to store sales figures for 5 weeks (7 days per week)
  - **Functionality**:
    - Calculate various statistics, including:
      - Total and average sales for each week
      - Total sales across all weeks and average weekly sales
      - Identification of the weeks with the highest and lowest sales amounts
    - Provides methods to print the raw sales array and the calculated analytical data
   
`SalesDriver`

The main entry point and user interface
  - **Functionality**:
    - Initializes the `FileIO` to load data and creates the `Franchise` object
    - Uses a `Scanner` to capture user input
    - Runs an indefinite loop, allowing the user to view specific analytical data or quit the application
    - Calls `store.print()` to display results based on user selection
   
## Additional Details

The UML diagram of the program is in `Analysis_UML.jpg`

More details about each class are in their respective `.txt` files.

## Disclaimer
This project was created for academic purposes.
