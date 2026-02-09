from controller.MongoConnection import MongoConnection

class MongoDAO:

    def save(self, numbers):
        try:
            db = MongoConnection.get_connection()
            if db is None:
                return False

            collection = db["Strategy"]

            document = {
                "numbers": numbers
            }

            collection.insert_one(document)
            return True

        except Exception as e:
            print("Error MongoDB:", e)
            return False
