import matplotlib.pyplot as plt


if __name__ == '__main__':
    f = open("output.txt", 'r')

    quant = []
    avgW = []
    avgTaT = []
    #print(f.readline())
    while True:
        t = f.readline()
        #print(t)

        if t is "":
            break
        a,b,c = map(float, t.split())
        quant.append(int(a))
        avgW.append(b)
        avgTaT.append(c)
    f.close()

    fig = plt.figure(1)
    fig.subplots_adjust(hspace=.5)
    ax1 = plt.subplot(211)
    plt.xlabel('quantum')
    plt.ylabel('average waiting time')
    ax1.set_title("quantum vs average waiting time")
    plt.plot(quant, avgW)


    ax2 = plt.subplot(212)
    ax2.set_title("quantum vs average turn around time")
    plt.plot(quant, avgTaT)
    plt.show()
