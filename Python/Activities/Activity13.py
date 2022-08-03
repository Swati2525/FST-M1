# Taking list of elements
InputList = list(input("Enter comma separated number: ").split(","))

# Defining Sum function 
def sum(NumbersList):
    totalsum = 0
    for list in NumbersList:
        totalsum = totalsum + int(list)
    print ("The sum is: ", totalsum)

# Calling Sum function
sum(InputList) 
