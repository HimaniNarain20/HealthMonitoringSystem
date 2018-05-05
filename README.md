# HealthMonitoringSystem
The Health Monitoring System measures the the heart rate of the patient and uploads it to the Firebase Using Arduino Uno . This android code retrieves the data history along with with the currently measured value of the patient into the android application. 
The device uses Heart rate sensors to measure the Heart rate of the patient. It then uses arduino coding to upload the data to the Real time Database for each and ever patient seperately. 
The database keeps track of the valid users for Login/SignUp and stores the personal information of each user along with their name ,age , gender, currently measured heart rate value , last measured heart rate value , and the normal value for that age and gender. 
In case of a disparity in the currently measured and the normal value for that patient, the database also stores the contact information of the patients' doctor.
The android application provides a calling activity to the doctor for the above situation.
