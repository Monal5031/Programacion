source ../lab-venv/bin/activate
java -jar "/home/fsociety/Desktop/Programacion/dist/Programacion.jar"
rm log.txt
echo ""
echo "Plotting Graph Please Wait..."
python3 plotter.py
deactivate
