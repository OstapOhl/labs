class Goods:
    def __init__(self, name, price, available_amount):
        self.name = name
        self.price = price
        self.available_amount = available_amount

    def printDefoltData(self):
        print( "Name: " + self.name + ", price: " + str(self.price) + ", amount: " + str(self.available_amount) )

    def taxesCount(self):
        priceAfterTaxes = self.price + self.price/100*20
        return priceAfterTaxes      

    def totalPrice(self):
        totalPrice = self.taxesCount() + self.taxesCount()/100*10
        return totalPrice



class Accounting(Goods):
    def __init__(self, name, price, available_amount, storage_numb):
        super().__init__(name, price, available_amount)

        self.available_amount = available_amount
        self.storage_numb = storage_numb


    def printaccountingData(self):
        print( "Name: " + self.name + ", price: " + str(self.price) + ", amount: " + str(self.available_amount)
        + ", available: " + str(self.available_amount) + ", storage number: " + str(self.storage_numb) )


class Customer(Goods):

    def __init__(self, name, price_with_taxes):
        super().__init__(name)
        self.price_with_taxes = price_with_taxes


bike = Accounting(name = "bike", price = 10000, available_amount = 6, storage_numb = 12344 )

bike.printaccountingData()

print("\n\n")

print("Price with taxes: ", bike.taxesCount())
print("Total price: ", bike.totalPrice())

