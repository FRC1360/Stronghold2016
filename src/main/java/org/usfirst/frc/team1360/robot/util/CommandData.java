package org.usfirst.frc.team1360.robot.util;

import java.util.List;

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
    private List<Double> doubles;
    /**
     * All booleans used.
     */
    private List<Boolean> booleans;
    /**
     * All floats used.
     */
    private List<Float> floats;

    /**
     * Get the list of all doubles
     * @return all doubles.
     */
    public List<Double> getDoubles()
    {
        return doubles;
    }

    /**
     * Add a double to the list.
     * @param d to add
     */
    public void addDouble(double d)
    {
        doubles.add(d);
    }

    /**
     * Set what the list is. Not used much.
     * @param doubles List to override current one
     */
    public void setDoubles(List<Double> doubles)
    {
        this.doubles = doubles;
    }

    /**
     * Get all booleans.
     * @return all booleans
     */
    public List<Boolean> getBooleans()
    {
        return booleans;
    }

    /**
     * Add a boolean.
     * @param b to add
     */
    public void addBoolean(boolean b)
    {
        booleans.add(b);
    }

    /**
     * Set what the list is. Not used much.
     * @param booleans List to override current one
     */
    public void setBooleans(List<Boolean> booleans)
    {
        this.booleans = booleans;
    }

    /**
     * Get all floats
     * @return all floats
     */
    public List<Float> getFloats()
    {
        return floats;
    }

    /**
     * Adds a float
     * @param f to add
     */
    public void addFloat(float f)
    {
        floats.add(f);
    }

    /**
     * Set what the list is. Not used much.
     * @param floats List to override current one
     */
    public void setFloats(List<Float> floats)
    {
        this.floats = floats;
    }
}
