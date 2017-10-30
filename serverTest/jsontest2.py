from Drinks import Drink
import json

json_data=open("test2.json","r")
args = json.load(json_data)
drinkList = []

for arg in args['orderList']:
    drink = Drink(**arg)
    drinkList.append(drink)

print drinkList[0].sugar
print drinkList[1].__dict__
