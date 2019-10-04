 1.	Use the postgresql driver to connect to the database located at reddwarf.cs.rit.edu/.
The username and password are csci605 and sometables respectively.
You will need to download the postgresql driver which can be found here, https://jdbc.postgresql.org/download.html. This will require you to use an external jar as a part of your project. 

Once connected you should send the SQL command below and use the result.

SELECT to_parse FROM sites;

2.	Based on the result from the database query, you will parse the resulting URL and find the hidden html found in the source code of that html. 

3.	You will then need to take the hidden html and download the contents into a file on your computer. 

4.	Then you will need to compile the contents using javac and run the code displaying the output of your newly compiled file, this is done programmatically. 


