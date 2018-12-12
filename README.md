# AirlineTicketBooking-FullStack

Service app:
-----------
Login into mysql and execute below commands to create required database and user
CREATE DATABASE atbs ; 
create user 'atbsuser' identified by 'Welcome1'; 
grant all on atbs.* to 'atbsuser'@'%';
run the spring boot application

UI app:
------
Enable proxy for below url , this url is used to import bootstrap css
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css)
go to atbs-app folder and execute below command to run app ng serve

Data:
I have generated some amount of flight data . select * from atbs.flights;
While testing please select 
Destination from: NY to: LV 
date : date on which you are testing.
time : 5 hrs 0 mins(will check flights on or after date and time)
passenger: select a number from dropdown. 
class: Business. Note:(you can select criteria based on #1 too)
