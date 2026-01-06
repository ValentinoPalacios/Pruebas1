from pymongo import MongoClient

class MongoConnection:
    _client = None
    _db = None

    @staticmethod
    def get_database():
        if MongoConnection._client is None:
            MongoConnection._client = MongoClient(
                "mongodb+srv://Paulo:paulo2004@cluster0.9uxqgih.mongodb.net/?retryWrites=true&w=majority"
            )
            MongoConnection._db = MongoConnection._client["Stores"]
        return MongoConnection._db
