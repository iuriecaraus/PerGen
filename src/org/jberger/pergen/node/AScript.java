/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.jberger.pergen.node;

import org.jberger.pergen.analysis.Analysis;
import java.util.*;

@SuppressWarnings("nls")
public final class AScript extends PScript
{
    private final LinkedList<PEntityDefinition> _entityDefinition_ = new LinkedList<PEntityDefinition>();

    public AScript()
    {
        // Constructor
    }

    public AScript(
        @SuppressWarnings("hiding") List<PEntityDefinition> _entityDefinition_)
    {
        // Constructor
        setEntityDefinition(_entityDefinition_);

    }

    @Override
    public Object clone()
    {
        return new AScript(
            cloneList(this._entityDefinition_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAScript(this);
    }

    public LinkedList<PEntityDefinition> getEntityDefinition()
    {
        return this._entityDefinition_;
    }

    public void setEntityDefinition(List<PEntityDefinition> list)
    {
        this._entityDefinition_.clear();
        this._entityDefinition_.addAll(list);
        for(PEntityDefinition e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._entityDefinition_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._entityDefinition_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PEntityDefinition> i = this._entityDefinition_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PEntityDefinition) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}