**1)How to clear s3 bucket cache ?**


Context: When you update objects in an Amazon S3 bucket (especially static files like images, CSS, or JS used in a website), if they’re served via CloudFront, browsers may still show the cached (old) version.



Ways to clear cache:



**CloudFront Invalidation** – Go to AWS CloudFront → Distributions → Invalidations → Create a new invalidation (/\* to clear all files or specify file paths).



**Change Object Versioning** – Append a version parameter to file URLs (e.g., file.js?v=2), so browsers fetch the updated file.



**Reduce Cache TTL** – Configure lower TTL in CloudFront or set appropriate Cache-Control headers in S3.


**2)How to versioning the s3 bucket ?**


Go to S3 → Select your bucket → Properties → Bucket Versioning → Enable.



Benefits:



Keeps multiple versions of an object.



You can restore deleted or overwritten objects.



Note: Enabling versioning may increase storage cost since older versions are also stored.


**3)What is SNS and how to improve the size ?**

SNS (Simple Notification Service):



A fully managed pub/sub messaging service.



Publishers send messages to a topic → SNS delivers them to subscribers (HTTP/S endpoints, SQS, Lambda, email, SMS).



Improving the size limit:



SNS has a 256 KB max message size.



If your message is larger:



Store the actual data in S3 and publish only the S3 URL via SNS.



Compress the data before sending.



Split large messages into chunks and send separately.


**4)What is cloud formation?**

AWS CloudFormation is an Infrastructure as Code (IaC) service.



You define your infrastructure in a JSON or YAML template (EC2, S3, VPC, etc.).



CloudFormation automatically provisions and manages resources as per the template.



Benefits:



Repeatable deployments.



Version-controlled infrastructure.



Automated rollback on failure.






**5)What is lambda ?**

AWS Lambda is a serverless computing service.



You write a function (Node.js, Python, Java, etc.) → upload it → Lambda runs it in response to events (S3 upload, API Gateway call, CloudWatch event, etc.).



Benefits:



No server management.



Pay only for execution time.



Scales automatically.







