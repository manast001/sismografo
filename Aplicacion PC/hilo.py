import threading
import time

class Hilo(threading.Thread):
    def __init__(self,progress): 
        threading.Thread.__init__(self)
        self.n=0
        self.progress=progress
        
    def run(self):
        while self.n != 100:
            self.progress.setValue(self.n+1)
            time.sleep(.1)
            self.n+=1
        self.n=0
        self.progress.setValue(0)