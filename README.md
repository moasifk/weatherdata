# weatherdata
This is an application to generate dummy weatherdata.

To build this application you require following.
Apache Maven 2.6 or higher
Java 1.7 or higher

You can run this application after a build with following command
java -cp weatherdata-0.0.1-SNAPSHOT.jar com.au.weatherdata.WeatherDataGen inputData.txt 2016-06-20 30 output.txt
Here the arg[0] inputData.txt is weatherdata file made from the sample wether details from the 
arg[1] is the date from which we need to generate dummy data.
arg[2] is the duration for which we need to generate the sample data.
arg[4] is the output llocation for the generated data.