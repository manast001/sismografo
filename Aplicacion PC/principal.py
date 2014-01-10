from wiimote import *
from PyQt4.QtCore import *
from PyQt4 import uic
from PyQt4 import *
from hilo import *


( Ui_MainWindow, QMainWindow ) = uic.loadUiType( 'mainwindow.ui' )

class MainWindow ( QMainWindow ):
    """MainWindow inherits QMainWindow"""

    def __init__ ( self, parent = None ):
        QMainWindow.__init__( self, parent )
        self.ui = Ui_MainWindow()
        self.sincronizate=0
        self.n=0
        
        
        self.ui.setupUi( self )
        
        #self.hilo=Hilo(self.ui.progress)
        self.wiimote=WiiRemote()
        self.connect(self.ui.sincronizar, SIGNAL("clicked()"),self.clickSincronizate)

    def __del__ ( self ):
        self.ui = None
    

    def clickSincronizate(self):
            if self.sincronizate==0:
                
                #self.hilo.start()
                self.sincronizate=1
                QtGui.QMessageBox.question(self, 'Mensaje',"Presione 1 y 2", QtGui.QMessageBox.Ok, QtGui.QMessageBox.Ok)
                self.wiimote.connect()
                self.ui.sincronizar.setText("Desincronizar WiiMotes")
                

            else:
                self.ui.sincronizar.setText("Sincronizar WiiMotes")
                self.sincronizate=0
                try:
                    self.wiimote.disconnect()
                except:
                    self.ui.progress.setValue(0)
                while self.n != 100:
                    self.ui.progress.setValue(self.n+1)
                    time.sleep(.1)
                    self.n+=1
                self.n=0
                self.ui.progress.setValue(0)
               
                
    
    
