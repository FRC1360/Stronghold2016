package main.java.org.usfirst.frc.team1360.robot.util;

import java.util.HashMap;

/**
 * CommandData - Used so that Commands can be used with reflection. This allows dynamic loading of the Autonomous Tasks
 * All List's should be converted over to HashMaps to allow naming of the values. This allows future proofing. Was not done to allow a
 * lesson to be taught on it.
 */
public class CommandData
{
    /**
     * All doubles used.
     */
    private HashMap<String, Double> doubles;
    /**
     * All booleans used.
     */
    private HashMap<String, Boolean> booleans;
    /**
     * All floats used.
     */
    private HashMap<String, Float> floats;

    /**
     * Get the list of all doubles
     * @return all doubles.
     */
    public HashMap<String, Double> getDoubles()
    {
        return doubles;
    }

    /**
     * Add a double to the list.
     * @param key Key
     * @param v Value
     */
    public void addDouble(String key, double v)
    {
        doubles.put(key, v);
    }

    /**
     * Set what the list is. Not used much.
     * @param doubles List to override current one
     */
    public void setDoubles(HashMap<String, Double> doubles)
    {
        this.doubles = doubles;
    }

    /**
     * Get all booleans.
     * @return all booleans
     */
    public HashMap<String, Boolean> getBooleans()
    {
        return booleans;
    }

    /**
     * Add a boolean.
     * @param k key
     * @param v to add
     */
    public void addBoolean(String k, boolean v)
    {
        booleans.put(k, v);
    }

    /**
     * Set what the list is. Not used much.
     * @param booleans List to override current one
     */
    public void setBooleans(HashMap<String, Boolean> booleans)
    {
        this.booleans = booleans;
    }

    /**
     * Get all floats
     * @return all floats
     */
    public HashMap<String, Float> getFloats()
    {
        return floats;
    }

    /**
     * Adds a float
     * @param k key
     * @param f to add
     */
    public void addFloat(String k, float f)
    {
        floats.put(k, f);
    }

    /**
     * Set what the list is. Not used much.
     * @param floats List to override current one
     */
    public void setFloats(HashMap<String, Float> floats)
    {
        this.floats = floats;
    }

    /**
     * Reset all values.
     */
    public void clear()
    {
        floats.clear();
        booleans.clear();
        doubles.clear();
    }
}
