from Drinks import Drink
import json

# args = {'drink':'yoyo tea', 'ingredients':'shit', 'ice':5,'sugar':5}
json_data=open("test.json","r")
args = json.load(json_data)

drink = Drink(**args)

print drink.__dict__
print drink.drink
