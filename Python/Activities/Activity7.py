Example_list = list(input("Enter comma separated values: ").split(","))
sum = 0
for list in Example_list:
    sum = sum + int(list)

print ("The sum is: ", sum)