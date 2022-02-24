# DiscountsChallenge
Java program based on Unidays discount challenge which can be found [here](https://github.com/MyUNiDAYS/tech-placement-challenge)

The main focus whilst creating the solution was modularity and real  
world use cases, so that simple alterations could be made to allow  
for interactions with a database or api instead. For example, rather  
than relying on keeping track of all items, like what the  
[ItemCatalogue](./src/main/ItemCatalogue.java) does, the class could be altered to make a query/http  
call to retrieve items rather than retrieving them from the contained  
data structure.  
