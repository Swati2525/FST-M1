#Create Car class
class Car:
    'This car class to define car properties'
    # INIT function
    def __init__(self,manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color
    # accelerate method
    def accelerate(self):
        print (self.manufacturer + " " + str(self.model) + " is moving.")
    # stop method
    def stop(self):
        print (self.manufacturer + " " + str(self.model) + " is stopped.")

# 3 different car objects
c1 = Car("Maruti",800,2014,"Manual","Red")
c2 = Car("Audi","etron",2021,"Automatic","White")
c3 = Car("Toyota","Fortuner",2022,"Manual","Black,")

c1.accelerate()
c2.stop()
print (c3.color)