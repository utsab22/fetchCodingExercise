# Fetch Coding SDET Automation Challenge

## Project Description

This project aims to create an automated solution for detecting a fake gold bar among a set of nine identical-looking bars using a simulated balance scale on the website [Fetch SDET Challenge](http://sdetchallenge.fetch.com/). The challenge involves two main components: developing an algorithm to efficiently identify the fake gold bar and implementing a test automation project to interact with the website.

## Preconditions and Dependencies

Before running the project, ensure the following preconditions and dependencies are met:

1. **Google Chrome/Firefox:** Make sure you have the latest version of Google Chrome/Firefox installed on your system.

2. **Maven:** Make sure Maven is installed on your system.

3. **Clone the Project:** Clone this project to your local machine.

4. **Quarantine Restriction (Mac):** If you are using a Mac and encounter quarantine restrictions, navigate to the project's root directory and execute the following command:

    ```bash
    cd Drivers/119;
    xattr -d com.apple.quarantine chromedriver;
    ```

## Run Instructions

To run the automation tests, follow these instructions:

1. Open a terminal in the project's root directory.

2. Run the following Maven command:

    ```bash
    mvn clean test -DsuiteXmlFile=TestNG.xml
    ```
3. **For Cross Browser Compatibility Testing:** To test on different browsers, modify the `browser` parameter in the `TestNG.xml` file. Options are "chrome" and "firefox".

   Example (TestNG.xml):
    ```xml
    <parameter name="browser" value="chrome"/>
    ```
   or
    ```xml
    <parameter name="browser" value="firefox"/>
    ```
Feel free to reach out if you have any questions or encounter issues!

