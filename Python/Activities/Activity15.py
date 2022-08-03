#strX = 5
# not defined strX
try:
 print(strX)
except NameError:
    print("strX hasn't been defined yet.")
