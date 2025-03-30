import hashlib
from time import gmtime
import time

class Block:
    def __init__(self, value, prev):
        self.time = gmtime()
        self.value = value
        self.prev = prev
        self.hash = self.calc_hash()

        
    def calc_hash(self):
          sha = hashlib.sha256()
          hash_str = (self.value+str(self.time)+str(self.prev)).encode('utf-8')
          sha.update(hash_str)
          return sha.hexdigest()


    def gmtime(self) :
        return "GMT: "+time.strftime("%a, %d %b %Y %I:%M:%S %p %Z", time.gmtime())

    
class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

        
    def toString(self):
        if self.next is None:
            print(self.value)
            return
        
        print(self.value, end = '-> ')
        self.next.toString()

        
class Chain :
    def __init__(self) :
        self.head = None

        
    def append(self, value) :
        if not self.head :
            self.head = Node(Block(str(value), 0))
            return

        node = Node(Block(str(value), self.head.value.hash))
        node.next = self.head
        self.head = node



print()
chain = Chain()
chain.append(None)
print(chain.head.value.hash)
print(chain.head.value.prev)
print(chain.head.value.time)
#408d24c17f3d8403d00b57d57e4a11dc6f04f02cbeceb1f2d2acf67da722fe73
#0
#time.struct_time(tm_year=2020, tm_mon=6, tm_mday=20, tm_hour=16, tm_min=42, tm_sec=36, tm_wday=5, tm_yday=172, tm_isdst=0)
print()

chain.append(None)
print(chain.head.value.hash)
print(chain.head.value.prev)
print(chain.head.value.time)
#c023f08654274b880d0fbc299e8689e4093513d57ef37c6b42ce5b779278e15b
#408d24c17f3d8403d00b57d57e4a11dc6f04f02cbeceb1f2d2acf67da722fe73
#time.struct_time(tm_year=2020, tm_mon=6, tm_mday=20, tm_hour=16, tm_min=42, tm_sec=36, tm_wday=5, tm_yday=172, tm_isdst=0)
print()

chain = Chain()
chain.append(True)
print(chain.head.value.hash)
print(chain.head.value.prev)
print(chain.head.value.time)
#81500bccabce86491d29da83b9264f999da32dae971e7dc741733d06c4f7d116
#0
#time.struct_time(tm_year=2020, tm_mon=6, tm_mday=20, tm_hour=16, tm_min=42, tm_sec=36, tm_wday=5, tm_yday=172, tm_isdst=0)
print()

chain.append(False)
print(chain.head.value.hash)
print(chain.head.value.prev)
print(chain.head.value.time)
#c9c5f52aa4f2cceb4ba344d4c1affe842c2460a00eccd4cc857aee5c0104265a
#81500bccabce86491d29da83b9264f999da32dae971e7dc741733d06c4f7d116
#time.struct_time(tm_year=2020, tm_mon=6, tm_mday=20, tm_hour=16, tm_min=42, tm_sec=36, tm_wday=5, tm_yday=172, tm_isdst=0)
print()

chain = Chain()
chain.append("transaction 1")
print(chain.head.value.hash)
print(chain.head.value.prev)
print(chain.head.value.time)
#513683ac6488425cc2ee67f25a5a645d99dee7873de2a7f59ea5f0e6c993aa24
#0
#time.struct_time(tm_year=2020, tm_mon=6, tm_mday=20, tm_hour=16, tm_min=42, tm_sec=36, tm_wday=5, tm_yday=172, tm_isdst=0)
print()

chain.append("transaction 2")
print(chain.head.value.hash)
print(chain.head.value.prev)
print(chain.head.value.time)
#8600ee01dd0efaa6940e33a637d8eee9748fb364ce3ae1281448449de9aa7d59
#513683ac6488425cc2ee67f25a5a645d99dee7873de2a7f59ea5f0e6c993aa24
#time.struct_time(tm_year=2020, tm_mon=6, tm_mday=20, tm_hour=16, tm_min=42, tm_sec=36, tm_wday=5, tm_yday=172, tm_isdst=0)
print()




