from pymongo import MongoClient

class MongoConnection:
    _URI = "mongodb+srv://Paulo:paulo2004@cluster0.9uxqgih.mongodb.net/?retryWrites=true&w=majority"
    _DATABASE = "Strategy"
    _client = None

    @staticmethod
    def get_connection():
        try:
            if MongoConnection._client is None:
                MongoConnection._client = MongoClient(MongoConnection._URI)

            return MongoConnection._client[MongoConnection._DATABASE]

        except Exception as e:
            print("Error al conectar MongoDB:", e)
            return None