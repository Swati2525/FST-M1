User1Name = input ("Enter User1 name: ").upper()
User2Name = input ("Enter User2 name: ").upper()

User1Response = input ("Enter User1 Response: ").lower()
User2Response = input ("Enter User2 Response: ").lower()

# Main logic 

if (User1Response == User2Response ):
    print ("it is a tie")
elif (User1Response == "rock"):
    if(User2Response == "scissors"):
        print (User1Name +" response: Rock wins")
    else:
         print (User2Name + " response: Paper wins")
elif (User1Response == "scissors"):
    if(User2Response == "paper"):
         print (User1Name +" response: Scissors wins")
    else:
         print (User2Name + " response: Rock wins")
elif (User1Response == "paper"):
    if(User2Response == "rock"):
        print (User1Name +" response: Paper wins")
    else:
         print (User2Name + " response: Scissors wins")
else:
     print ("Enter valid User1 or User2 response.")  
