InputNumber = int(input("How many terms? "))
firstNumber = 0
#generate fibonacci sequence
def myFibonacci(nterms):
    # first two terms
    n1, n2 = 0, 1
    count = 0
    while count < nterms:
        print(n1)
        nth = n1 + n2
        # update values
        n1 = n2
        n2 = nth
        count += 1
    #return MyList

# check if the number of terms is valid
if InputNumber <= 0:
   print("Please enter a positive integer")
# if there is only one term, return n1
elif InputNumber == 1:
   print("Fibonacci sequence :")
   print(firstNumber)
# printing Fibonacci series
else:
   print("Fibonacci sequence: ")
   print (myFibonacci(InputNumber))


