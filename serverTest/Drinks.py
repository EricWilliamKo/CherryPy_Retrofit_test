class Drink:

    def __init__(self, **entries):
        self.nextMove = None
        self.ingredients = None
        self.sugar = 0
        self.ice = 0
        self.drink = None
        self.id = None
        self.manufacturingProcess = []
        self.__dict__.update(entries)
        