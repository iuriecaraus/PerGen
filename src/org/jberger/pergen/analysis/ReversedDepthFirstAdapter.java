/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.jberger.pergen.analysis;

import org.jberger.pergen.node.AManyRelationDefinition;
import org.jberger.pergen.node.AOneRelationDefinition;
import org.jberger.pergen.node.AMoreInnerDefinition;
import org.jberger.pergen.node.AUnicityInnerDefinition;
import org.jberger.pergen.node.ARealDataType;
import org.jberger.pergen.node.AMayBeZero;
import org.jberger.pergen.node.AUnicityDefinition;
import org.jberger.pergen.node.AScript;
import org.jberger.pergen.node.Node;
import org.jberger.pergen.node.ARelationInnerDefinition;
import org.jberger.pergen.node.Start;
import org.jberger.pergen.node.PMoreInnerDefinition;
import org.jberger.pergen.node.AMoreIdentifier;
import org.jberger.pergen.node.AEntityDefinition;
import org.jberger.pergen.node.PEntityDefinition;
import org.jberger.pergen.node.AFieldInnerDefinition;
import org.jberger.pergen.node.PMoreIdentifier;
import org.jberger.pergen.node.AStringDataType;
import org.jberger.pergen.node.AFieldDefinition;
import org.jberger.pergen.node.ADateDataType;
import org.jberger.pergen.node.AStringLength;
import org.jberger.pergen.node.AIntegerDataType;
import java.util.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPScript().apply(this);
        outStart(node);
    }

    public void inAScript(AScript node)
    {
        defaultIn(node);
    }

    public void outAScript(AScript node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAScript(AScript node)
    {
        inAScript(node);
        {
            List<PEntityDefinition> copy = new ArrayList<PEntityDefinition>(node.getEntityDefinition());
            Collections.reverse(copy);
            for(PEntityDefinition e : copy)
            {
                e.apply(this);
            }
        }
        outAScript(node);
    }

    public void inAEntityDefinition(AEntityDefinition node)
    {
        defaultIn(node);
    }

    public void outAEntityDefinition(AEntityDefinition node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEntityDefinition(AEntityDefinition node)
    {
        inAEntityDefinition(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        {
            List<PMoreInnerDefinition> copy = new ArrayList<PMoreInnerDefinition>(node.getMoreInnerDefinition());
            Collections.reverse(copy);
            for(PMoreInnerDefinition e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getInnerDefinition() != null)
        {
            node.getInnerDefinition().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getEntity() != null)
        {
            node.getEntity().apply(this);
        }
        outAEntityDefinition(node);
    }

    public void inAFieldInnerDefinition(AFieldInnerDefinition node)
    {
        defaultIn(node);
    }

    public void outAFieldInnerDefinition(AFieldInnerDefinition node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFieldInnerDefinition(AFieldInnerDefinition node)
    {
        inAFieldInnerDefinition(node);
        if(node.getFieldDefinition() != null)
        {
            node.getFieldDefinition().apply(this);
        }
        outAFieldInnerDefinition(node);
    }

    public void inARelationInnerDefinition(ARelationInnerDefinition node)
    {
        defaultIn(node);
    }

    public void outARelationInnerDefinition(ARelationInnerDefinition node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARelationInnerDefinition(ARelationInnerDefinition node)
    {
        inARelationInnerDefinition(node);
        if(node.getRelationDefinition() != null)
        {
            node.getRelationDefinition().apply(this);
        }
        outARelationInnerDefinition(node);
    }

    public void inAUnicityInnerDefinition(AUnicityInnerDefinition node)
    {
        defaultIn(node);
    }

    public void outAUnicityInnerDefinition(AUnicityInnerDefinition node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAUnicityInnerDefinition(AUnicityInnerDefinition node)
    {
        inAUnicityInnerDefinition(node);
        if(node.getUnicityDefinition() != null)
        {
            node.getUnicityDefinition().apply(this);
        }
        outAUnicityInnerDefinition(node);
    }

    public void inAMoreInnerDefinition(AMoreInnerDefinition node)
    {
        defaultIn(node);
    }

    public void outAMoreInnerDefinition(AMoreInnerDefinition node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMoreInnerDefinition(AMoreInnerDefinition node)
    {
        inAMoreInnerDefinition(node);
        if(node.getInnerDefinition() != null)
        {
            node.getInnerDefinition().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        outAMoreInnerDefinition(node);
    }

    public void inAFieldDefinition(AFieldDefinition node)
    {
        defaultIn(node);
    }

    public void outAFieldDefinition(AFieldDefinition node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFieldDefinition(AFieldDefinition node)
    {
        inAFieldDefinition(node);
        if(node.getRequired() != null)
        {
            node.getRequired().apply(this);
        }
        if(node.getDataType() != null)
        {
            node.getDataType().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAFieldDefinition(node);
    }

    public void inAOneRelationDefinition(AOneRelationDefinition node)
    {
        defaultIn(node);
    }

    public void outAOneRelationDefinition(AOneRelationDefinition node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOneRelationDefinition(AOneRelationDefinition node)
    {
        inAOneRelationDefinition(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getOne() != null)
        {
            node.getOne().apply(this);
        }
        if(node.getMayBeZero() != null)
        {
            node.getMayBeZero().apply(this);
        }
        if(node.getHas() != null)
        {
            node.getHas().apply(this);
        }
        outAOneRelationDefinition(node);
    }

    public void inAManyRelationDefinition(AManyRelationDefinition node)
    {
        defaultIn(node);
    }

    public void outAManyRelationDefinition(AManyRelationDefinition node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAManyRelationDefinition(AManyRelationDefinition node)
    {
        inAManyRelationDefinition(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getMany() != null)
        {
            node.getMany().apply(this);
        }
        if(node.getMayBeZero() != null)
        {
            node.getMayBeZero().apply(this);
        }
        if(node.getHas() != null)
        {
            node.getHas().apply(this);
        }
        outAManyRelationDefinition(node);
    }

    public void inAUnicityDefinition(AUnicityDefinition node)
    {
        defaultIn(node);
    }

    public void outAUnicityDefinition(AUnicityDefinition node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAUnicityDefinition(AUnicityDefinition node)
    {
        inAUnicityDefinition(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        {
            List<PMoreIdentifier> copy = new ArrayList<PMoreIdentifier>(node.getMoreIdentifier());
            Collections.reverse(copy);
            for(PMoreIdentifier e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getUnique() != null)
        {
            node.getUnique().apply(this);
        }
        outAUnicityDefinition(node);
    }

    public void inADateDataType(ADateDataType node)
    {
        defaultIn(node);
    }

    public void outADateDataType(ADateDataType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADateDataType(ADateDataType node)
    {
        inADateDataType(node);
        if(node.getDate() != null)
        {
            node.getDate().apply(this);
        }
        outADateDataType(node);
    }

    public void inAIntegerDataType(AIntegerDataType node)
    {
        defaultIn(node);
    }

    public void outAIntegerDataType(AIntegerDataType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntegerDataType(AIntegerDataType node)
    {
        inAIntegerDataType(node);
        if(node.getInteger() != null)
        {
            node.getInteger().apply(this);
        }
        outAIntegerDataType(node);
    }

    public void inARealDataType(ARealDataType node)
    {
        defaultIn(node);
    }

    public void outARealDataType(ARealDataType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARealDataType(ARealDataType node)
    {
        inARealDataType(node);
        if(node.getReal() != null)
        {
            node.getReal().apply(this);
        }
        outARealDataType(node);
    }

    public void inAStringDataType(AStringDataType node)
    {
        defaultIn(node);
    }

    public void outAStringDataType(AStringDataType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringDataType(AStringDataType node)
    {
        inAStringDataType(node);
        if(node.getStringLength() != null)
        {
            node.getStringLength().apply(this);
        }
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        outAStringDataType(node);
    }

    public void inAStringLength(AStringLength node)
    {
        defaultIn(node);
    }

    public void outAStringLength(AStringLength node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringLength(AStringLength node)
    {
        inAStringLength(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        outAStringLength(node);
    }

    public void inAMayBeZero(AMayBeZero node)
    {
        defaultIn(node);
    }

    public void outAMayBeZero(AMayBeZero node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMayBeZero(AMayBeZero node)
    {
        inAMayBeZero(node);
        if(node.getTo() != null)
        {
            node.getTo().apply(this);
        }
        if(node.getZero() != null)
        {
            node.getZero().apply(this);
        }
        outAMayBeZero(node);
    }

    public void inAMoreIdentifier(AMoreIdentifier node)
    {
        defaultIn(node);
    }

    public void outAMoreIdentifier(AMoreIdentifier node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMoreIdentifier(AMoreIdentifier node)
    {
        inAMoreIdentifier(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        outAMoreIdentifier(node);
    }
}
