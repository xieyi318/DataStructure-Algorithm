import numpy as np  
import matplotlib.pyplot as plt  
from scipy import optimize  
  

def f_1(x, A, B):  
    return A*x + B  

def f_2(x, A, B, C):  
    return A*x*x + B*x + C  
  
def f_3(x, A, B):  
    return A*np.log2(x) + B  
  
def plot_test():  
  


    x01 = [1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384]  
    y01 = [0,0.215,0.835,1.55619,2.466694,3.607877,4.769213,6.140596,7.34659,8.776372,10.21508,11.49384,12.91616,14.2426,15.72582]  

    x02 = [1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384]  
    y02 = [0,0.5,1.5,3.5,7.5,15.5,31.5,63.5,127.5,255.5,511.5,1023.5,2047.5,4095.5,8191.5]
    
  
    plt.scatter(x01[:], y01[:], 25, "blue")  
    #plt.scatter(x02[:], y02[:], 25, "red")

    
    A1, B1= optimize.curve_fit(f_3, x01, y01)[0]  
    x1 = np.arange(0, 17000, 0.01)  
    y1 = A1*np.log2(x1) + B1  
    plt.plot(x1, y1, "blue", label="random")  
  
    A2, B2= optimize.curve_fit(f_1, x02, y02)[0]  
    x2 = np.arange(0, 17000, 0.01)  
    y2 =A2*x2 + B2  
    #plt.plot(x2, y2, "red", label="sorted") 
    
    plt.legend(loc='upper left')
  
    plt.title("BTS")  
    plt.xlabel('size')  
    plt.ylabel('path length')  
  
    plt.show()  
    print("y="+str(A1)+"log(x)+("+str(B1)+")")
    #print("y="+str(A2)+"x+("+str(B2)+")")
  
    return  

plot_test()