# smash_test
Smash Costa Rica Assessment project

This project contains the assessment sent by Smash CR.<br>
Please find below all my assumptions or some things I considered to developed the required tool:<br><br>

1.Database should be created manually. We have the option to create a DB automatically from the entities, however I prefer to manually create the DB structures to provide a better control. Also I like to include comments to tables and fields that can help understand the reason behind creating a field or table.<br><br>
2.Database scripts are included. You must runt the scripts in the required order using a user with enough permissions to create a database and the tables.<br><br>
3.Seleted database is MySQL.<br><br>
4.Files needed transformation. CellPhone file was ok, you can import it using MySQL Workbench. For CellPhoneUsage I had to fixed the date values in order to be able to import it directly. Both files are also included here.<br><br>
5.CellPhoneUsage data has duplicaded values for some Employees, I assumed that this information is not duplicated and considered all 1000 entries as valid. To avoid the duplication error I added a new field to this table called Id. This way every item will be unique.<br><br>
6.Since real printing capabilities can be time consuming I went ahead and created an utility to print to console. There are multiple options to generate a simple report and print the results. I think the logic behind the structure and get the data correctly takes precedence over the printer.<br><br>
<br><br>
### Application Design
1.This application is using latest SpringBoot framework in command line mode.<br><br>
2.Everything is inside one single module, the reason behind this is to keep the project simple. On a real life project usually you should split your projects into different modules either by layer (data, business logic, web services, ui) or by functionalities.<br><br>
3.The class ReportHeader contains the header details for the report, it is a model class that can be used at UI level. Inside of this class we need to handle the details, so I created a list attribute of type ReportDetails. This class stores the required details. As per the requirement, we have a 3 level inside the details which are actually the Columns for each Month. I created another class called MonthlyUsage to store the Year-Month and the accumulated data for it.<br><br>
4.We can say these structures are using the Composite pattern at some degree since we are encapsulating details inside Nodes. However, the current structure can be improved so we can handle each one of this elements as ReportElement or ReportSection and each of these classes can extend this main class and expose a print method. That way we delegate the printing (either to console or create the XML for the report utility) logic to each element. Due to the time constraint I couldn't implement this feature, but it can be added to improve readability and reuse code. Just some food for thought.<br><br>
5.The service CellPhoneUsageService (business logic) handles all required logic to create the objects mentioned above. It only goes to the DB using a repository class.<br><br>
6.The repository class is using dynamic method creation. This means that Spring will automatically create required query to get the information by date range and sorted  by the date. This helps a lot since no complex code is needed.<br><br>
7.All components are injected automatically by the Autowired annotation.<br>

### How to run the app?
1.Execute the scripts inside the folder db_scripts<br><br>
2.Import the CSV files inside sample_data folder<br><br>
3.Open the file messages.properties inside resources folder. Locate the properties report.from.date and report.to.date.<br><br>
4.The property report.from.date stores the desired from date.<br><br>
5.The property report.to.date stores the desired end date.<br><br>
6.Please use YYYY-MM-DD format. If you use a different format the application will skip the report creation and you will see a log of type INFO in the console.<br><br>
7.Import the dependendices with Maven. If you are using IntelliJ or other IDE this should happen as soon as you open the project.<br><br>
8.Run the application. You will see a console print with all the report details as required.<br><br>


### Thanks for the oportunity and for sharing this exercise, it was fun :)<br><br>

### PS
If you are looking to review additional coding skills, please check my blog www.runnablepatterns.com
<br><br>
Also, you can check some projects in my github, also related to the blog here: https://github.com/orgs/runnablepatterns/repositories



