# Define two lists  
List1 = [4,5,6,3,9,7]
List2 = [8,27,5,7,3,2]

# Print both lists 
print ("List1: ",List1)
print("List2: ",List2 )

# Declare list3
List3 = []

#Main logic
# Taking Odd number from list 1
for item in List1:                              
    if(item % 2 != 0):
      List3.append(item)  

# Taking even number from list 2
for item in List2:                              
    if(item % 2 == 0):
      List3.append(item) 

# Print final list
print ("Final list is: ",List3)


