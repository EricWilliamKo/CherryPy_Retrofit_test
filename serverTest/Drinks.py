

class Drink():
    drink = None
    ingredients = None
    sugar = 0
    ice = 0
    
    # def __init__(self, drink,ingredients,sugar,ice):
    #     self.ice = ice
    #     self.drink = drink
    #     self.ingredients = ingredients
    #     self.sugar = sugar

    def __init__(self, **entries):
        self.__dict__.update(entries)