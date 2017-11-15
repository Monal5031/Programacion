#/bin/bash
source ../lab-venv/bin/activate
java -jar "/home/fsociety/Desktop/Programacion/dist/Programacion.jar"
echo ""
echo "Is the Algorithm Round Robin?"
echo "yes or no"
read inp
if [ $inp == "yes" ]
  then
    echo "Plotting Graph Please Wait..."
    echo ""
    python3 plotter.py
fi
deactivate
echo "Thank you! Thats all folks!"
