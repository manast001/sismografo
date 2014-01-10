import pygame
import wiiuse.pygame_wiimote as pygame_wiimote


class WiiRemote:
    def __init__(self):
        self.n=0
        
    def connect(self):
        while self.n==0:
            pygame_wiimote.init(1,5)
            self.n=pygame_wiimote.get_count()
        self.wm = pygame_wiimote.Wiimote(0)
        self.wm.enable_accels(1)   
    
    def disconnect(self):
        pygame_wiimote.quit()
    
    