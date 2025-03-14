package yusuke.client.util.noise;

public class FastNoiseLite
{
    public static class Vector3
    {
        public float x;
        public float y;
        public float z;

        public Vector3(final float x, final float y, final float z) {
            super();
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static class Vector2
    {
        public float x;
        public float y;

        public Vector2(final float x, final float y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
    private enum TransformType3D
    {
        None("None", 0),
        ImproveXYPlanes("ImproveXYPlanes", 1),
        ImproveXZPlanes("ImproveXZPlanes", 2),
        DefaultOpenSimplex2("DefaultOpenSimplex2", 3);

        private static final /* synthetic */ TransformType3D[] ENUM$VALUES;

        static {
            ENUM$VALUES = new TransformType3D[] { TransformType3D.None, TransformType3D.ImproveXYPlanes, TransformType3D.ImproveXZPlanes, TransformType3D.DefaultOpenSimplex2 };
        }

        private TransformType3D(final String name, final int ordinal) {
        }
//
//        public static TransformType3D[] values() {
//            final TransformType3D[] enum$VALUES = TransformType3D.ENUM$VALUES;
//            final int length;
//            final TransformType3D[] array;
//            System.arraycopy(enum$VALUES, 0, array = new TransformType3D[length = enum$VALUES.length], 0, length);
//            return array;
//        }
//
//        public static TransformType3D valueOf(final String name) {
//            return Enum.valueOf(TransformType3D.class, name);
//        }
    }

    public enum RotationType3D
    {
        None("None", 0),
        ImproveXYPlanes("ImproveXYPlanes", 1),
        ImproveXZPlanes("ImproveXZPlanes", 2);

        private static final /* synthetic */ RotationType3D[] ENUM$VALUES;

        static {
            ENUM$VALUES = new RotationType3D[] { RotationType3D.None, RotationType3D.ImproveXYPlanes, RotationType3D.ImproveXZPlanes };
        }

        private RotationType3D(final String name, final int ordinal) {
        }

//        public static RotationType3D[] values() {
//            final RotationType3D[] enum$VALUES = RotationType3D.ENUM$VALUES;
//            final int length;
//            final RotationType3D[] array;
//            System.arraycopy(enum$VALUES, 0, array = new RotationType3D[length = enum$VALUES.length], 0, length);
//            return array;
//        }
//
//        public static RotationType3D valueOf(final String name) {
//            return Enum.valueOf(RotationType3D.class, name);
//        }
    }

    public enum NoiseType
    {
        OpenSimplex2("OpenSimplex2", 0),
        OpenSimplex2S("OpenSimplex2S", 1),
        Cellular("Cellular", 2),
        Perlin("Perlin", 3),
        ValueCubic("ValueCubic", 4),
        Value("Value", 5);

        private static final /* synthetic */ NoiseType[] ENUM$VALUES;

        static {
            ENUM$VALUES = new NoiseType[] { NoiseType.OpenSimplex2, NoiseType.OpenSimplex2S, NoiseType.Cellular, NoiseType.Perlin, NoiseType.ValueCubic, NoiseType.Value };
        }

        private NoiseType(final String name, final int ordinal) {
        }

//        public static NoiseType[] values() {
//            final NoiseType[] enum$VALUES = NoiseType.ENUM$VALUES;
//            final int length;
//            final NoiseType[] array;
//            System.arraycopy(enum$VALUES, 0, array = new NoiseType[length = enum$VALUES.length], 0, length);
//            return array;
//        }
//
//        public static NoiseType valueOf(final String name) {
//            return Enum.valueOf(NoiseType.class, name);
//        }
    }

    public enum FractalType
    {
        None("None", 0),
        FBm("FBm", 1),
        Ridged("Ridged", 2),
        PingPong("PingPong", 3),
        DomainWarpProgressive("DomainWarpProgressive", 4),
        DomainWarpIndependent("DomainWarpIndependent", 5);

//        private static final /* synthetic */ yusuke.client.util.noise.FastNoiseLite.FractalType[] ENUM$VALUES;
//
//        static {
//            ENUM$VALUES = new yusuke.client.util.noise.FastNoiseLite.FractalType[] { yusuke.client.util.noise.FastNoiseLite.FractalType.None, yusuke.client.util.noise.FastNoiseLite.FractalType.FBm, yusuke.client.util.noise.FastNoiseLite.FractalType.Ridged, yusuke.client.util.noise.FastNoiseLite.FractalType.PingPong, yusuke.client.util.noise.FastNoiseLite.FractalType.DomainWarpProgressive, yusuke.client.util.noise.FastNoiseLite.FractalType.DomainWarpIndependent };
//        }

        private FractalType(final String name, final int ordinal) {
        }

//        public static yusuke.client.util.noise.FastNoiseLite.FractalType[] values() {
//            final yusuke.client.util.noise.FastNoiseLite.FractalType[] enum$VALUES = yusuke.client.util.noise.FastNoiseLite.FractalType.ENUM$VALUES;
//            final int length;
//            final yusuke.client.util.noise.FastNoiseLite.FractalType[] array;
//            System.arraycopy(enum$VALUES, 0, array = new yusuke.client.util.noise.FastNoiseLite.FractalType[length = enum$VALUES.length], 0, length);
//            return array;
//        }
//
//        public static yusuke.client.util.noise.FastNoiseLite.FractalType valueOf(final String name) {
//            return Enum.valueOf(yusuke.client.util.noise.FastNoiseLite.FractalType.class, name);
//        }
    }

    public enum DomainWarpType
    {
        OpenSimplex2("OpenSimplex2", 0),
        OpenSimplex2Reduced("OpenSimplex2Reduced", 1),
        BasicGrid("BasicGrid", 2);

        private static final /* synthetic */ DomainWarpType[] ENUM$VALUES;

        static {
            ENUM$VALUES = new DomainWarpType[] { DomainWarpType.OpenSimplex2, DomainWarpType.OpenSimplex2Reduced, DomainWarpType.BasicGrid };
        }

        private DomainWarpType(final String name, final int ordinal) {
        }

//        public static DomainWarpType[] values() {
//            final DomainWarpType[] enum$VALUES = DomainWarpType.ENUM$VALUES;
//            final int length;
//            final DomainWarpType[] array;
//            System.arraycopy(enum$VALUES, 0, array = new DomainWarpType[length = enum$VALUES.length], 0, length);
//            return array;
//        }
//
//        public static DomainWarpType valueOf(final String name) {
//            return Enum.valueOf(DomainWarpType.class, name);
//        }
    }

    public enum CellularDistanceFunction
    {
        Euclidean("Euclidean", 0),
        EuclideanSq("EuclideanSq", 1),
        Manhattan("Manhattan", 2),
        Hybrid("Hybrid", 3);

        private static final /* synthetic */ CellularDistanceFunction[] ENUM$VALUES;

        static {
            ENUM$VALUES = new CellularDistanceFunction[] { CellularDistanceFunction.Euclidean, CellularDistanceFunction.EuclideanSq, CellularDistanceFunction.Manhattan, CellularDistanceFunction.Hybrid };
        }

        private CellularDistanceFunction(final String name, final int ordinal) {
        }
//
//        public static CellularDistanceFunction[] values() {
//            final CellularDistanceFunction[] enum$VALUES = CellularDistanceFunction.ENUM$VALUES;
//            final int length;
//            final CellularDistanceFunction[] array;
//            System.arraycopy(enum$VALUES, 0, array = new CellularDistanceFunction[length = enum$VALUES.length], 0, length);
//            return array;
//        }
//
//        public static CellularDistanceFunction valueOf(final String name) {
//            return Enum.valueOf(CellularDistanceFunction.class, name);
//        }
    }

    public enum CellularReturnType
    {
        CellValue("CellValue", 0),
        Distance("Distance", 1),
        Distance2("Distance2", 2),
        Distance2Add("Distance2Add", 3),
        Distance2Sub("Distance2Sub", 4),
        Distance2Mul("Distance2Mul", 5),
        Distance2Div("Distance2Div", 6);

        private static final /* synthetic */ CellularReturnType[] ENUM$VALUES;

        static {
            ENUM$VALUES = new CellularReturnType[] { CellularReturnType.CellValue, CellularReturnType.Distance, CellularReturnType.Distance2, CellularReturnType.Distance2Add, CellularReturnType.Distance2Sub, CellularReturnType.Distance2Mul, CellularReturnType.Distance2Div };
        }

        private CellularReturnType(final String name, final int ordinal) {
        }
//
//        public static CellularReturnType[] values() {
//            final CellularReturnType[] enum$VALUES = CellularReturnType.ENUM$VALUES;
//            final int length;
//            final CellularReturnType[] array;
//            System.arraycopy(enum$VALUES, 0, array = new CellularReturnType[length = enum$VALUES.length], 0, length);
//            return array;
//        }
//
//        public static CellularReturnType valueOf(final String name) {
//            return Enum.valueOf(CellularReturnType.class, name);
//        }
    }


    private int mSeed;
    private float mFrequency;
    private NoiseType mNoiseType;
    private RotationType3D mRotationType3D;
    private TransformType3D mTransformType3D;
    private FractalType mFractalType;
    private int mOctaves;
    private float mLacunarity;
    private float mGain;
    private float mWeightedStrength;
    private float mPingPongStrength;
    private float mFractalBounding;
    private CellularDistanceFunction mCellularDistanceFunction;
    private CellularReturnType mCellularReturnType;
    private float mCellularJitterModifier;
    private DomainWarpType mDomainWarpType;
    private TransformType3D mWarpTransformType3D;
    private float mDomainWarpAmp;
    private static final float[] Gradients2D;
    private static final float[] RandVecs2D;
    private static final float[] Gradients3D;
    private static final float[] RandVecs3D;
    private static final int PrimeX = 501125321;
    private static final int PrimeY = 1136930381;
    private static final int PrimeZ = 1720413743;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType;
    
    static {
        Gradients2D = new float[] { 0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.6087614f, 0.7933533f, 0.7933533f, 0.6087614f, 0.9238795f, 0.38268343f, 0.9914449f, 0.13052619f, 0.9914449f, -0.13052619f, 0.9238795f, -0.38268343f, 0.7933533f, -0.6087614f, 0.6087614f, -0.7933533f, 0.38268343f, -0.9238795f, 0.13052619f, -0.9914449f, -0.13052619f, -0.9914449f, -0.38268343f, -0.9238795f, -0.6087614f, -0.7933533f, -0.7933533f, -0.6087614f, -0.9238795f, -0.38268343f, -0.9914449f, -0.13052619f, -0.9914449f, 0.13052619f, -0.9238795f, 0.38268343f, -0.7933533f, 0.6087614f, -0.6087614f, 0.7933533f, -0.38268343f, 0.9238795f, -0.13052619f, 0.9914449f, 0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.6087614f, 0.7933533f, 0.7933533f, 0.6087614f, 0.9238795f, 0.38268343f, 0.9914449f, 0.13052619f, 0.9914449f, -0.13052619f, 0.9238795f, -0.38268343f, 0.7933533f, -0.6087614f, 0.6087614f, -0.7933533f, 0.38268343f, -0.9238795f, 0.13052619f, -0.9914449f, -0.13052619f, -0.9914449f, -0.38268343f, -0.9238795f, -0.6087614f, -0.7933533f, -0.7933533f, -0.6087614f, -0.9238795f, -0.38268343f, -0.9914449f, -0.13052619f, -0.9914449f, 0.13052619f, -0.9238795f, 0.38268343f, -0.7933533f, 0.6087614f, -0.6087614f, 0.7933533f, -0.38268343f, 0.9238795f, -0.13052619f, 0.9914449f, 0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.6087614f, 0.7933533f, 0.7933533f, 0.6087614f, 0.9238795f, 0.38268343f, 0.9914449f, 0.13052619f, 0.9914449f, -0.13052619f, 0.9238795f, -0.38268343f, 0.7933533f, -0.6087614f, 0.6087614f, -0.7933533f, 0.38268343f, -0.9238795f, 0.13052619f, -0.9914449f, -0.13052619f, -0.9914449f, -0.38268343f, -0.9238795f, -0.6087614f, -0.7933533f, -0.7933533f, -0.6087614f, -0.9238795f, -0.38268343f, -0.9914449f, -0.13052619f, -0.9914449f, 0.13052619f, -0.9238795f, 0.38268343f, -0.7933533f, 0.6087614f, -0.6087614f, 0.7933533f, -0.38268343f, 0.9238795f, -0.13052619f, 0.9914449f, 0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.6087614f, 0.7933533f, 0.7933533f, 0.6087614f, 0.9238795f, 0.38268343f, 0.9914449f, 0.13052619f, 0.9914449f, -0.13052619f, 0.9238795f, -0.38268343f, 0.7933533f, -0.6087614f, 0.6087614f, -0.7933533f, 0.38268343f, -0.9238795f, 0.13052619f, -0.9914449f, -0.13052619f, -0.9914449f, -0.38268343f, -0.9238795f, -0.6087614f, -0.7933533f, -0.7933533f, -0.6087614f, -0.9238795f, -0.38268343f, -0.9914449f, -0.13052619f, -0.9914449f, 0.13052619f, -0.9238795f, 0.38268343f, -0.7933533f, 0.6087614f, -0.6087614f, 0.7933533f, -0.38268343f, 0.9238795f, -0.13052619f, 0.9914449f, 0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.6087614f, 0.7933533f, 0.7933533f, 0.6087614f, 0.9238795f, 0.38268343f, 0.9914449f, 0.13052619f, 0.9914449f, -0.13052619f, 0.9238795f, -0.38268343f, 0.7933533f, -0.6087614f, 0.6087614f, -0.7933533f, 0.38268343f, -0.9238795f, 0.13052619f, -0.9914449f, -0.13052619f, -0.9914449f, -0.38268343f, -0.9238795f, -0.6087614f, -0.7933533f, -0.7933533f, -0.6087614f, -0.9238795f, -0.38268343f, -0.9914449f, -0.13052619f, -0.9914449f, 0.13052619f, -0.9238795f, 0.38268343f, -0.7933533f, 0.6087614f, -0.6087614f, 0.7933533f, -0.38268343f, 0.9238795f, -0.13052619f, 0.9914449f, 0.38268343f, 0.9238795f, 0.9238795f, 0.38268343f, 0.9238795f, -0.38268343f, 0.38268343f, -0.9238795f, -0.38268343f, -0.9238795f, -0.9238795f, -0.38268343f, -0.9238795f, 0.38268343f, -0.38268343f, 0.9238795f };
        RandVecs2D = new float[] { -0.2700222f, -0.9628541f, 0.38630927f, -0.9223693f, 0.04444859f, -0.9990117f, -0.59925234f, -0.80056024f, -0.781928f, 0.62336874f, 0.9464672f, 0.32279992f, -0.6514147f, -0.7587219f, 0.93784726f, 0.34704837f, -0.8497876f, -0.52712524f, -0.87904257f, 0.47674325f, -0.8923003f, -0.45144236f, -0.37984443f, -0.9250504f, -0.9951651f, 0.09821638f, 0.7724398f, -0.635088f, 0.75732833f, -0.6530343f, -0.9928005f, -0.119780056f, -0.05326657f, 0.99858034f, 0.97542536f, -0.22033007f, -0.76650184f, 0.64224213f, 0.9916367f, 0.12906061f, -0.99469686f, 0.10285038f, -0.53792053f, -0.8429955f, 0.50228155f, -0.86470413f, 0.45598215f, -0.8899889f, -0.8659131f, -0.50019443f, 0.08794584f, -0.9961253f, -0.5051685f, 0.8630207f, 0.7753185f, -0.6315704f, -0.69219446f, 0.72171104f, -0.51916593f, -0.85467345f, 0.8978623f, -0.4402764f, -0.17067741f, 0.98532695f, -0.935343f, -0.35374206f, -0.99924046f, 0.038967468f, -0.2882064f, -0.9575683f, -0.96638113f, 0.2571138f, -0.87597144f, -0.48236302f, -0.8303123f, -0.55729836f, 0.051101338f, -0.99869347f, -0.85583735f, -0.51724505f, 0.098870255f, 0.9951003f, 0.9189016f, 0.39448678f, -0.24393758f, -0.96979094f, -0.81214094f, -0.5834613f, -0.99104315f, 0.13354214f, 0.8492424f, -0.52800316f, -0.9717839f, -0.23587295f, 0.9949457f, 0.10041421f, 0.6241065f, -0.7813392f, 0.6629103f, 0.74869883f, -0.7197418f, 0.6942418f, -0.8143371f, -0.58039224f, 0.10452105f, -0.9945227f, -0.10659261f, -0.99430275f, 0.44579968f, -0.8951328f, 0.105547406f, 0.99441427f, -0.9927903f, 0.11986445f, -0.83343667f, 0.55261505f, 0.9115562f, -0.4111756f, 0.8285545f, -0.55990845f, 0.7217098f, -0.6921958f, 0.49404928f, -0.8694339f, -0.36523214f, -0.9309165f, -0.9696607f, 0.24445485f, 0.089255095f, -0.9960088f, 0.5354071f, -0.8445941f, -0.10535762f, 0.9944344f, -0.98902845f, 0.1477251f, 0.004856105f, 0.9999882f, 0.98855984f, 0.15082914f, 0.92861295f, -0.37104982f, -0.5832394f, -0.8123003f, 0.30152076f, 0.9534596f, -0.95751107f, 0.28839657f, 0.9715802f, -0.23671055f, 0.2299818f, 0.97319496f, 0.9557638f, -0.2941352f, 0.7409561f, 0.67155343f, -0.9971514f, -0.07542631f, 0.69057107f, -0.7232645f, -0.2907137f, -0.9568101f, 0.5912778f, -0.80646795f, -0.94545925f, -0.3257405f, 0.66644555f, 0.7455537f, 0.6236135f, 0.78173286f, 0.9126994f, -0.40863165f, -0.8191762f, 0.57354194f, -0.8812746f, -0.4726046f, 0.99533135f, 0.09651673f, 0.98556507f, -0.16929697f, -0.8495981f, 0.52743065f, 0.6174854f, -0.78658235f, 0.85081565f, 0.5254643f, 0.99850327f, -0.0546925f, 0.19713716f, -0.98037595f, 0.66078556f, -0.7505747f, -0.030974941f, 0.9995202f, -0.6731661f, 0.73949134f, -0.71950185f, -0.69449055f, 0.97275114f, 0.2318516f, 0.9997059f, -0.02425069f, 0.44217876f, -0.89692694f, 0.9981351f, -0.061043672f, -0.9173661f, -0.39804456f, -0.81500566f, -0.579453f, -0.87893313f, 0.476945f, 0.015860584f, 0.99987423f, -0.8095465f, 0.5870558f, -0.9165899f, -0.39982867f, -0.8023543f, 0.5968481f, -0.5176738f, 0.85557806f, -0.8154407f, -0.57884055f, 0.40220103f, -0.91555136f, -0.9052557f, -0.4248672f, 0.7317446f, 0.681579f, -0.56476325f, -0.825253f, -0.8403276f, -0.54207885f, -0.93142813f, 0.36392525f, 0.52381986f, 0.85182905f, 0.7432804f, -0.66898f, -0.9853716f, -0.17041974f, 0.46014687f, 0.88784283f, 0.8258554f, 0.56388193f, 0.6182366f, 0.785992f, 0.83315027f, -0.55304664f, 0.15003075f, 0.9886813f, -0.6623304f, -0.7492119f, -0.66859865f, 0.74362344f, 0.7025606f, 0.7116239f, -0.54193896f, -0.84041786f, -0.33886164f, 0.9408362f, 0.833153f, 0.55304253f, -0.29897207f, -0.95426184f, 0.2638523f, 0.9645631f, 0.12410874f, -0.9922686f, -0.7282649f, -0.6852957f, 0.69625f, 0.71779937f, -0.91835356f, 0.395761f, -0.6326102f, -0.7744703f, -0.9331892f, -0.35938552f, -0.11537793f, -0.99332166f, 0.9514975f, -0.30765656f, -0.08987977f, -0.9959526f, 0.6678497f, 0.7442962f, 0.79524004f, -0.6062947f, -0.6462007f, -0.7631675f, -0.27335986f, 0.96191186f, 0.966959f, -0.25493184f, -0.9792895f, 0.20246519f, -0.5369503f, -0.84361386f, -0.27003646f, -0.9628501f, -0.6400277f, 0.76835185f, -0.78545374f, -0.6189204f, 0.060059056f, -0.9981948f, -0.024557704f, 0.9996984f, -0.65983623f, 0.7514095f, -0.62538946f, -0.7803128f, -0.6210409f, -0.7837782f, 0.8348889f, 0.55041856f, -0.15922752f, 0.9872419f, 0.83676225f, 0.54756635f, -0.8675754f, -0.4973057f, -0.20226626f, -0.97933054f, 0.939919f, 0.34139755f, 0.98774046f, -0.1561049f, -0.90344554f, 0.42870283f, 0.12698042f, -0.9919052f, -0.3819601f, 0.92417884f, 0.9754626f, 0.22016525f, -0.32040158f, -0.94728184f, -0.9874761f, 0.15776874f, 0.025353484f, -0.99967855f, 0.4835131f, -0.8753371f, -0.28508f, -0.9585037f, -0.06805516f, -0.99768156f, -0.7885244f, -0.61500347f, 0.3185392f, -0.9479097f, 0.8880043f, 0.45983514f, 0.64769214f, -0.76190215f, 0.98202413f, 0.18875542f, 0.93572754f, -0.35272372f, -0.88948953f, 0.45695552f, 0.7922791f, 0.6101588f, 0.74838185f, 0.66326815f, -0.728893f, -0.68462765f, 0.8729033f, -0.48789328f, 0.8288346f, 0.5594937f, 0.08074567f, 0.99673474f, 0.97991484f, -0.1994165f, -0.5807307f, -0.81409574f, -0.47000498f, -0.8826638f, 0.2409493f, 0.9705377f, 0.9437817f, -0.33056942f, -0.89279985f, -0.45045355f, -0.80696225f, 0.59060305f, 0.062589735f, 0.99803936f, -0.93125975f, 0.36435598f, 0.57774496f, 0.81621736f, -0.3360096f, -0.9418586f, 0.69793206f, -0.71616393f, -0.0020081573f, -0.999998f, -0.18272944f, -0.98316324f, -0.6523912f, 0.7578824f, -0.43026268f, -0.9027037f, -0.9985126f, -0.054520912f, -0.010281022f, -0.99994713f, -0.49460712f, 0.86911666f, -0.299935f, 0.95395964f, 0.8165472f, 0.5772787f, 0.26974604f, 0.9629315f, -0.7306287f, -0.68277496f, -0.7590952f, -0.65097964f, -0.9070538f, 0.4210146f, -0.5104861f, -0.859886f, 0.86133504f, 0.5080373f, 0.50078815f, -0.8655699f, -0.6541582f, 0.7563578f, -0.83827555f, -0.54524684f, 0.6940071f, 0.7199682f, 0.06950936f, 0.9975813f, 0.17029423f, -0.9853933f, 0.26959732f, 0.9629731f, 0.55196124f, -0.83386976f, 0.2256575f, -0.9742067f, 0.42152628f, -0.9068162f, 0.48818734f, -0.87273884f, -0.3683855f, -0.92967314f, -0.98253906f, 0.18605645f, 0.81256473f, 0.582871f, 0.3196461f, -0.947537f, 0.9570914f, 0.28978625f, -0.6876655f, -0.7260276f, -0.9988771f, -0.04737673f, -0.1250179f, 0.9921545f, -0.82801336f, 0.56070834f, 0.93248636f, -0.36120513f, 0.63946533f, 0.7688199f, -0.016238471f, -0.99986815f, -0.99550146f, -0.094746135f, -0.8145332f, 0.580117f, 0.4037328f, -0.91487694f, 0.9944263f, 0.10543368f, -0.16247116f, 0.9867133f, -0.9949488f, -0.10038388f, -0.69953024f, 0.714603f, 0.5263415f, -0.85027325f, -0.5395222f, 0.8419714f, 0.65793705f, 0.7530729f, 0.014267588f, -0.9998982f, -0.6734384f, 0.7392433f, 0.6394121f, -0.7688642f, 0.9211571f, 0.38919085f, -0.14663722f, -0.98919034f, -0.7823181f, 0.6228791f, -0.5039611f, -0.8637264f, -0.774312f, -0.632804f };
        Gradients3D = new float[] { 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f };
        RandVecs3D = new float[] { -0.7292737f, -0.66184396f, 0.17355819f, 0.0f, 0.7902921f, -0.5480887f, -0.2739291f, 0.0f, 0.7217579f, 0.62262124f, -0.3023381f, 0.0f, 0.5656831f, -0.8208298f, -0.079000026f, 0.0f, 0.76004905f, -0.55559796f, -0.33709997f, 0.0f, 0.37139457f, 0.50112647f, 0.78162545f, 0.0f, -0.12770624f, -0.4254439f, -0.8959289f, 0.0f, -0.2881561f, -0.5815839f, 0.7607406f, 0.0f, 0.5849561f, -0.6628202f, -0.4674352f, 0.0f, 0.33071712f, 0.039165374f, 0.94291687f, 0.0f, 0.8712122f, -0.41133744f, -0.26793817f, 0.0f, 0.580981f, 0.7021916f, 0.41156778f, 0.0f, 0.5037569f, 0.6330057f, -0.5878204f, 0.0f, 0.44937122f, 0.6013902f, 0.6606023f, 0.0f, -0.6878404f, 0.090188906f, -0.7202372f, 0.0f, -0.59589565f, -0.64693505f, 0.47579765f, 0.0f, -0.5127052f, 0.1946922f, -0.83619875f, 0.0f, -0.99115074f, -0.054102764f, -0.12121531f, 0.0f, -0.21497211f, 0.9720882f, -0.09397608f, 0.0f, -0.7518651f, -0.54280573f, 0.37424695f, 0.0f, 0.5237069f, 0.8516377f, -0.021078179f, 0.0f, 0.6333505f, 0.19261672f, -0.74951047f, 0.0f, -0.06788242f, 0.39983058f, 0.9140719f, 0.0f, -0.55386287f, -0.47298968f, -0.6852129f, 0.0f, -0.72614557f, -0.5911991f, 0.35099334f, 0.0f, -0.9229275f, -0.17828088f, 0.34120494f, 0.0f, -0.6968815f, 0.65112746f, 0.30064803f, 0.0f, 0.96080446f, -0.20983632f, -0.18117249f, 0.0f, 0.068171464f, -0.9743405f, 0.21450691f, 0.0f, -0.3577285f, -0.6697087f, -0.65078455f, 0.0f, -0.18686211f, 0.7648617f, -0.61649746f, 0.0f, -0.65416974f, 0.3967915f, 0.64390874f, 0.0f, 0.699334f, -0.6164538f, 0.36182392f, 0.0f, -0.15466657f, 0.6291284f, 0.7617583f, 0.0f, -0.6841613f, -0.2580482f, -0.68215424f, 0.0f, 0.5383981f, 0.4258655f, 0.727163f, 0.0f, -0.5026988f, -0.7939833f, -0.3418837f, 0.0f, 0.32029718f, 0.28344154f, 0.9039196f, 0.0f, 0.86832273f, -3.7626564E-4f, -0.49599952f, 0.0f, 0.79112005f, -0.085110456f, 0.60571057f, 0.0f, -0.04011016f, -0.43972486f, 0.8972364f, 0.0f, 0.914512f, 0.35793462f, -0.18854876f, 0.0f, -0.96120393f, -0.27564842f, 0.010246669f, 0.0f, 0.65103614f, -0.28777993f, -0.70237786f, 0.0f, -0.20417863f, 0.73652375f, 0.6448596f, 0.0f, -0.7718264f, 0.37906268f, 0.5104856f, 0.0f, -0.30600828f, -0.7692988f, 0.56083715f, 0.0f, 0.45400733f, -0.5024843f, 0.73578995f, 0.0f, 0.48167956f, 0.6021208f, -0.636738f, 0.0f, 0.69619805f, -0.32221973f, 0.6414692f, 0.0f, -0.65321606f, -0.6781149f, 0.33685157f, 0.0f, 0.50893015f, -0.61546624f, -0.60182345f, 0.0f, -0.16359198f, -0.9133605f, -0.37284088f, 0.0f, 0.5240802f, -0.8437664f, 0.11575059f, 0.0f, 0.5902587f, 0.4983818f, -0.63498837f, 0.0f, 0.5863228f, 0.49476475f, 0.6414308f, 0.0f, 0.6779335f, 0.23413453f, 0.6968409f, 0.0f, 0.7177054f, -0.68589795f, 0.12017863f, 0.0f, -0.532882f, -0.5205125f, 0.6671608f, 0.0f, -0.8654874f, -0.07007271f, -0.4960054f, 0.0f, -0.286181f, 0.79520893f, 0.53454953f, 0.0f, -0.048495296f, 0.98108363f, -0.18741156f, 0.0f, -0.63585216f, 0.60583484f, 0.47818002f, 0.0f, 0.62547946f, -0.28616196f, 0.72586966f, 0.0f, -0.258526f, 0.50619495f, -0.8227582f, 0.0f, 0.021363068f, 0.50640166f, -0.862033f, 0.0f, 0.20011178f, 0.85992634f, 0.46955505f, 0.0f, 0.47435614f, 0.6014985f, -0.6427953f, 0.0f, 0.6622994f, -0.52024746f, -0.539168f, 0.0f, 0.08084973f, -0.65327203f, 0.7527941f, 0.0f, -0.6893687f, 0.059286036f, 0.7219805f, 0.0f, -0.11218871f, -0.96731853f, 0.22739525f, 0.0f, 0.7344116f, 0.59796685f, -0.3210533f, 0.0f, 0.5789393f, -0.24888498f, 0.776457f, 0.0f, 0.69881827f, 0.35571697f, -0.6205791f, 0.0f, -0.86368454f, -0.27487713f, -0.4224826f, 0.0f, -0.4247028f, -0.46408808f, 0.77733505f, 0.0f, 0.5257723f, -0.84270173f, 0.11583299f, 0.0f, 0.93438303f, 0.31630248f, -0.16395439f, 0.0f, -0.10168364f, -0.8057303f, -0.58348876f, 0.0f, -0.6529239f, 0.50602126f, -0.5635893f, 0.0f, -0.24652861f, -0.9668206f, -0.06694497f, 0.0f, -0.9776897f, -0.20992506f, -0.0073688254f, 0.0f, 0.7736893f, 0.57342446f, 0.2694238f, 0.0f, -0.6095088f, 0.4995679f, 0.6155737f, 0.0f, 0.5794535f, 0.7434547f, 0.33392924f, 0.0f, -0.8226211f, 0.081425816f, 0.56272936f, 0.0f, -0.51038545f, 0.47036678f, 0.719904f, 0.0f, -0.5764972f, -0.072316565f, -0.81389266f, 0.0f, 0.7250629f, 0.39499715f, -0.56414634f, 0.0f, -0.1525424f, 0.48608407f, -0.8604958f, 0.0f, -0.55509764f, -0.49578208f, 0.6678823f, 0.0f, -0.18836144f, 0.91458696f, 0.35784173f, 0.0f, 0.76255566f, -0.54144084f, -0.35404897f, 0.0f, -0.5870232f, -0.3226498f, -0.7424964f, 0.0f, 0.30511242f, 0.2262544f, -0.9250488f, 0.0f, 0.63795763f, 0.57724243f, -0.50970703f, 0.0f, -0.5966776f, 0.14548524f, -0.7891831f, 0.0f, -0.65833056f, 0.65554875f, -0.36994147f, 0.0f, 0.74348927f, 0.23510846f, 0.6260573f, 0.0f, 0.5562114f, 0.82643604f, -0.08736329f, 0.0f, -0.302894f, -0.8251527f, 0.47684193f, 0.0f, 0.11293438f, -0.9858884f, -0.123571075f, 0.0f, 0.5937653f, -0.5896814f, 0.5474657f, 0.0f, 0.6757964f, -0.58357584f, -0.45026484f, 0.0f, 0.7242303f, -0.11527198f, 0.67985505f, 0.0f, -0.9511914f, 0.0753624f, -0.29925808f, 0.0f, 0.2539471f, -0.18863393f, 0.9486454f, 0.0f, 0.5714336f, -0.16794509f, -0.8032796f, 0.0f, -0.06778235f, 0.39782694f, 0.9149532f, 0.0f, 0.6074973f, 0.73306f, -0.30589226f, 0.0f, -0.54354787f, 0.16758224f, 0.8224791f, 0.0f, -0.5876678f, -0.3380045f, -0.7351187f, 0.0f, -0.79675627f, 0.040978227f, -0.60290986f, 0.0f, -0.19963509f, 0.8706295f, 0.4496111f, 0.0f, -0.027876602f, -0.91062325f, -0.4122962f, 0.0f, -0.7797626f, -0.6257635f, 0.019757755f, 0.0f, -0.5211233f, 0.74016446f, -0.42495546f, 0.0f, 0.8575425f, 0.4053273f, -0.31675017f, 0.0f, 0.10452233f, 0.8390196f, -0.53396744f, 0.0f, 0.3501823f, 0.9242524f, -0.15208502f, 0.0f, 0.19878499f, 0.076476134f, 0.9770547f, 0.0f, 0.78459966f, 0.6066257f, -0.12809642f, 0.0f, 0.09006737f, -0.97509897f, -0.20265691f, 0.0f, -0.82743436f, -0.54229957f, 0.14582036f, 0.0f, -0.34857976f, -0.41580227f, 0.8400004f, 0.0f, -0.2471779f, -0.730482f, -0.6366311f, 0.0f, -0.3700155f, 0.8577948f, 0.35675845f, 0.0f, 0.59133947f, -0.54831195f, -0.59133035f, 0.0f, 0.120487355f, -0.7626472f, -0.6354935f, 0.0f, 0.6169593f, 0.03079648f, 0.7863923f, 0.0f, 0.12581569f, -0.664083f, -0.73699677f, 0.0f, -0.6477565f, -0.17401473f, -0.74170774f, 0.0f, 0.6217889f, -0.7804431f, -0.06547655f, 0.0f, 0.6589943f, -0.6096988f, 0.44044736f, 0.0f, -0.26898375f, -0.6732403f, -0.68876356f, 0.0f, -0.38497752f, 0.56765425f, 0.7277094f, 0.0f, 0.57544446f, 0.81104714f, -0.10519635f, 0.0f, 0.91415936f, 0.3832948f, 0.13190056f, 0.0f, -0.10792532f, 0.9245494f, 0.36545935f, 0.0f, 0.3779771f, 0.30431488f, 0.87437165f, 0.0f, -0.21428852f, -0.8259286f, 0.5214617f, 0.0f, 0.58025444f, 0.41480985f, -0.7008834f, 0.0f, -0.19826609f, 0.85671616f, -0.47615966f, 0.0f, -0.033815537f, 0.37731808f, -0.9254661f, 0.0f, -0.68679225f, -0.6656598f, 0.29191336f, 0.0f, 0.7731743f, -0.28757936f, -0.565243f, 0.0f, -0.09655942f, 0.91937083f, -0.3813575f, 0.0f, 0.27157024f, -0.957791f, -0.09426606f, 0.0f, 0.24510157f, -0.6917999f, -0.6792188f, 0.0f, 0.97770077f, -0.17538553f, 0.115503654f, 0.0f, -0.522474f, 0.8521607f, 0.029036159f, 0.0f, -0.77348804f, -0.52612925f, 0.35341796f, 0.0f, -0.71344924f, -0.26954725f, 0.6467878f, 0.0f, 0.16440372f, 0.5105846f, -0.84396374f, 0.0f, 0.6494636f, 0.055856112f, 0.7583384f, 0.0f, -0.4711971f, 0.50172806f, -0.7254256f, 0.0f, -0.63357645f, -0.23816863f, -0.7361091f, 0.0f, -0.9021533f, -0.2709478f, -0.33571818f, 0.0f, -0.3793711f, 0.8722581f, 0.3086152f, 0.0f, -0.68555987f, -0.32501432f, 0.6514394f, 0.0f, 0.29009423f, -0.7799058f, -0.5546101f, 0.0f, -0.20983194f, 0.8503707f, 0.48253515f, 0.0f, -0.45926037f, 0.6598504f, -0.5947077f, 0.0f, 0.87159455f, 0.09616365f, -0.48070312f, 0.0f, -0.6776666f, 0.71185046f, -0.1844907f, 0.0f, 0.7044378f, 0.3124276f, 0.637304f, 0.0f, -0.7052319f, -0.24010932f, -0.6670798f, 0.0f, 0.081921004f, -0.72073364f, -0.68835455f, 0.0f, -0.6993681f, -0.5875763f, -0.4069869f, 0.0f, -0.12814544f, 0.6419896f, 0.75592864f, 0.0f, -0.6337388f, -0.67854714f, -0.3714147f, 0.0f, 0.5565052f, -0.21688876f, -0.8020357f, 0.0f, -0.57915545f, 0.7244372f, -0.3738579f, 0.0f, 0.11757791f, -0.7096451f, 0.69467926f, 0.0f, -0.613462f, 0.13236311f, 0.7785528f, 0.0f, 0.69846356f, -0.029805163f, -0.7150247f, 0.0f, 0.83180827f, -0.3930172f, 0.39195976f, 0.0f, 0.14695764f, 0.055416517f, -0.98758924f, 0.0f, 0.70886856f, -0.2690504f, 0.65201014f, 0.0f, 0.27260533f, 0.67369765f, -0.68688995f, 0.0f, -0.65912956f, 0.30354586f, -0.68804663f, 0.0f, 0.48151314f, -0.752827f, 0.4487723f, 0.0f, 0.943001f, 0.16756473f, -0.28752613f, 0.0f, 0.43480295f, 0.7695305f, -0.46772778f, 0.0f, 0.39319962f, 0.5944736f, 0.70142365f, 0.0f, 0.72543365f, -0.60392565f, 0.33018148f, 0.0f, 0.75902355f, -0.6506083f, 0.024333132f, 0.0f, -0.8552769f, -0.3430043f, 0.38839358f, 0.0f, -0.6139747f, 0.6981725f, 0.36822575f, 0.0f, -0.74659055f, -0.575201f, 0.33428493f, 0.0f, 0.5730066f, 0.8105555f, -0.12109168f, 0.0f, -0.92258775f, -0.3475211f, -0.16751404f, 0.0f, -0.71058166f, -0.47196922f, -0.5218417f, 0.0f, -0.0856461f, 0.35830015f, 0.9296697f, 0.0f, -0.8279698f, -0.2043157f, 0.5222271f, 0.0f, 0.42794403f, 0.278166f, 0.8599346f, 0.0f, 0.539908f, -0.78571206f, -0.3019204f, 0.0f, 0.5678404f, -0.5495414f, -0.61283076f, 0.0f, -0.9896071f, 0.13656391f, -0.045034185f, 0.0f, -0.6154343f, -0.64408755f, 0.45430374f, 0.0f, 0.10742044f, -0.79463404f, 0.59750944f, 0.0f, -0.359545f, -0.888553f, 0.28495783f, 0.0f, -0.21804053f, 0.1529889f, 0.9638738f, 0.0f, -0.7277432f, -0.61640507f, -0.30072346f, 0.0f, 0.7249729f, -0.0066971947f, 0.68874484f, 0.0f, -0.5553659f, -0.5336586f, 0.6377908f, 0.0f, 0.5137558f, 0.79762083f, -0.316f, 0.0f, -0.3794025f, 0.92456084f, -0.035227515f, 0.0f, 0.82292485f, 0.27453658f, -0.49741766f, 0.0f, -0.5404114f, 0.60911417f, 0.5804614f, 0.0f, 0.8036582f, -0.27030295f, 0.5301602f, 0.0f, 0.60443187f, 0.68329686f, 0.40959433f, 0.0f, 0.06389989f, 0.96582085f, -0.2512108f, 0.0f, 0.10871133f, 0.74024713f, -0.6634878f, 0.0f, -0.7134277f, -0.6926784f, 0.10591285f, 0.0f, 0.64588976f, -0.57245487f, -0.50509584f, 0.0f, -0.6553931f, 0.73814714f, 0.15999562f, 0.0f, 0.39109614f, 0.91888714f, -0.05186756f, 0.0f, -0.48790225f, -0.5904377f, 0.64291114f, 0.0f, 0.601479f, 0.77074414f, -0.21018201f, 0.0f, -0.5677173f, 0.7511361f, 0.33688518f, 0.0f, 0.7858574f, 0.22667466f, 0.5753667f, 0.0f, -0.45203456f, -0.6042227f, -0.65618575f, 0.0f, 0.0022721163f, 0.4132844f, -0.9105992f, 0.0f, -0.58157516f, -0.5162926f, 0.6286591f, 0.0f, -0.03703705f, 0.8273786f, 0.5604221f, 0.0f, -0.51196927f, 0.79535437f, -0.324498f, 0.0f, -0.26824173f, -0.957229f, -0.10843876f, 0.0f, -0.23224828f, -0.9679131f, -0.09594243f, 0.0f, 0.3554329f, -0.8881506f, 0.29130062f, 0.0f, 0.73465204f, -0.4371373f, 0.5188423f, 0.0f, 0.998512f, 0.046590112f, -0.028339446f, 0.0f, -0.37276876f, -0.9082481f, 0.19007573f, 0.0f, 0.9173738f, -0.3483642f, 0.19252984f, 0.0f, 0.2714911f, 0.41475296f, -0.86848867f, 0.0f, 0.5131763f, -0.71163344f, 0.4798207f, 0.0f, -0.87373537f, 0.18886992f, -0.44823506f, 0.0f, 0.84600437f, -0.3725218f, 0.38145f, 0.0f, 0.89787275f, -0.17802091f, -0.40265754f, 0.0f, 0.21780656f, -0.9698323f, -0.10947895f, 0.0f, -0.15180314f, -0.7788918f, -0.6085091f, 0.0f, -0.2600385f, -0.4755398f, -0.840382f, 0.0f, 0.5723135f, -0.7474341f, -0.33734185f, 0.0f, -0.7174141f, 0.16990171f, -0.67561114f, 0.0f, -0.6841808f, 0.021457076f, -0.72899675f, 0.0f, -0.2007448f, 0.06555606f, -0.9774477f, 0.0f, -0.11488037f, -0.8044887f, 0.5827524f, 0.0f, -0.787035f, 0.03447489f, 0.6159443f, 0.0f, -0.20155965f, 0.68598723f, 0.69913894f, 0.0f, -0.085810825f, -0.10920836f, -0.99030805f, 0.0f, 0.5532693f, 0.73252505f, -0.39661077f, 0.0f, -0.18424894f, -0.9777375f, -0.100407675f, 0.0f, 0.07754738f, -0.9111506f, 0.40471104f, 0.0f, 0.13998385f, 0.7601631f, -0.63447344f, 0.0f, 0.44844192f, -0.84528923f, 0.29049253f, 0.0f };
    }
    
    public FastNoiseLite() {
        super();
        this.mSeed = 1337;
        this.mFrequency = 0.01f;
        this.mNoiseType = NoiseType.OpenSimplex2;
        this.mRotationType3D = RotationType3D.None;
        this.mTransformType3D = TransformType3D.DefaultOpenSimplex2;
        this.mFractalType = FractalType.None;
        this.mOctaves = 3;
        this.mLacunarity = 2.0f;
        this.mGain = 0.5f;
        this.mWeightedStrength = 0.0f;
        this.mPingPongStrength = 2.0f;
        this.mFractalBounding = 0.5714286f;
        this.mCellularDistanceFunction = CellularDistanceFunction.EuclideanSq;
        this.mCellularReturnType = CellularReturnType.Distance;
        this.mCellularJitterModifier = 1.0f;
        this.mDomainWarpType = DomainWarpType.OpenSimplex2;
        this.mWarpTransformType3D = TransformType3D.DefaultOpenSimplex2;
        this.mDomainWarpAmp = 1.0f;
    }
    
    public FastNoiseLite(final int seed) {
        super();
        this.mSeed = 1337;
        this.mFrequency = 0.01f;
        this.mNoiseType = NoiseType.OpenSimplex2;
        this.mRotationType3D = RotationType3D.None;
        this.mTransformType3D = TransformType3D.DefaultOpenSimplex2;
        this.mFractalType = FractalType.None;
        this.mOctaves = 3;
        this.mLacunarity = 2.0f;
        this.mGain = 0.5f;
        this.mWeightedStrength = 0.0f;
        this.mPingPongStrength = 2.0f;
        this.mFractalBounding = 0.5714286f;
        this.mCellularDistanceFunction = CellularDistanceFunction.EuclideanSq;
        this.mCellularReturnType = CellularReturnType.Distance;
        this.mCellularJitterModifier = 1.0f;
        this.mDomainWarpType = DomainWarpType.OpenSimplex2;
        this.mWarpTransformType3D = TransformType3D.DefaultOpenSimplex2;
        this.mDomainWarpAmp = 1.0f;
        this.SetSeed(seed);
    }
    
    public void SetSeed(final int seed) {
        this.mSeed = seed;
    }
    
    public void SetFrequency(final float frequency) {
        this.mFrequency = frequency;
    }
    
    public void SetNoiseType(final NoiseType noiseType) {
        this.mNoiseType = noiseType;
        this.UpdateTransformType3D();
    }
    
    public void SetRotationType3D(final RotationType3D rotationType3D) {
        this.mRotationType3D = rotationType3D;
        this.UpdateTransformType3D();
        this.UpdateWarpTransformType3D();
    }
    
    public void SetFractalType(final FractalType fractalType) {
        this.mFractalType = fractalType;
    }
    
    public void SetFractalOctaves(final int octaves) {
        this.mOctaves = octaves;
        this.CalculateFractalBounding();
    }
    
    public void SetFractalLacunarity(final float lacunarity) {
        this.mLacunarity = lacunarity;
    }
    
    public void SetFractalGain(final float gain) {
        this.mGain = gain;
        this.CalculateFractalBounding();
    }
    
    public void SetFractalWeightedStrength(final float weightedStrength) {
        this.mWeightedStrength = weightedStrength;
    }
    
    public void SetFractalPingPongStrength(final float pingPongStrength) {
        this.mPingPongStrength = pingPongStrength;
    }
    
    public void SetCellularDistanceFunction(final CellularDistanceFunction cellularDistanceFunction) {
        this.mCellularDistanceFunction = cellularDistanceFunction;
    }
    
    public void SetCellularReturnType(final CellularReturnType cellularReturnType) {
        this.mCellularReturnType = cellularReturnType;
    }
    
    public void SetCellularJitter(final float cellularJitter) {
        this.mCellularJitterModifier = cellularJitter;
    }
    
    public void SetDomainWarpType(final DomainWarpType domainWarpType) {
        this.mDomainWarpType = domainWarpType;
        this.UpdateWarpTransformType3D();
    }
    
    public void SetDomainWarpAmp(final float domainWarpAmp) {
        this.mDomainWarpAmp = domainWarpAmp;
    }
    
    public float GetNoise(float x, float y) {
        x *= this.mFrequency;
        y *= this.mFrequency;
        switch (this.mNoiseType) {
            case OpenSimplex2:
            case OpenSimplex2S: {
                final float SQRT3 = 1.7320508f;
                final float F2 = 0.3660254f;
                final float t = (x + y) * 0.3660254f;
                x += t;
                y += t;
                break;
            }
        }
        switch (this.mFractalType) {
            default: {
                return this.GenNoiseSingle(this.mSeed, x, y);
            }
            case FBm: {
                return this.GenFractalFBm(x, y);
            }
            case Ridged: {
                return this.GenFractalRidged(x, y);
            }
            case PingPong: {
                return this.GenFractalPingPong(x, y);
            }
        }
    }
    
    public float GetNoise(float x, float y, float z) {
        x *= this.mFrequency;
        y *= this.mFrequency;
        z *= this.mFrequency;
        switch (this.mTransformType3D) {
            case ImproveXYPlanes: {
                final float xy = x + y;
                final float s2 = xy * -0.21132487f;
                z *= 0.57735026f;
                x += s2 - z;
                y = y + s2 - z;
                z += xy * 0.57735026f;
                break;
            }
            case ImproveXZPlanes: {
                final float xz = x + z;
                final float s2 = xz * -0.21132487f;
                y *= 0.57735026f;
                x += s2 - y;
                z += s2 - y;
                y += xz * 0.57735026f;
                break;
            }
            case DefaultOpenSimplex2: {
                final float R3 = 0.6666667f;
                final float r = (x + y + z) * 0.6666667f;
                x = r - x;
                y = r - y;
                z = r - z;
                break;
            }
        }
        switch (this.mFractalType) {
            default: {
                return this.GenNoiseSingle(this.mSeed, x, y, z);
            }
            case FBm: {
                return this.GenFractalFBm(x, y, z);
            }
            case Ridged: {
                return this.GenFractalRidged(x, y, z);
            }
            case PingPong: {
                return this.GenFractalPingPong(x, y, z);
            }
        }
    }
    
    public void DomainWarp(final Vector2 coord) {
        switch (this.mFractalType) {
            default: {
                this.DomainWarpSingle(coord);
                break;
            }
            case DomainWarpProgressive: {
                this.DomainWarpFractalProgressive(coord);
                break;
            }
            case DomainWarpIndependent: {
                this.DomainWarpFractalIndependent(coord);
                break;
            }
        }
    }
    
    public void DomainWarp(final Vector3 coord) {
        switch (this.mFractalType) {
            default: {
                this.DomainWarpSingle(coord);
                break;
            }
            case DomainWarpProgressive: {
                this.DomainWarpFractalProgressive(coord);
                break;
            }
            case DomainWarpIndependent: {
                this.DomainWarpFractalIndependent(coord);
                break;
            }
        }
    }
    
    private static float FastMin(final float a, final float b) {
        return (a < b) ? a : b;
    }
    
    private static float FastMax(final float a, final float b) {
        return (a > b) ? a : b;
    }
    
    private static float FastAbs(final float f) {
        return (f < 0.0f) ? (-f) : f;
    }
    
    private static float FastSqrt(final float f) {
        return (float)Math.sqrt(f);
    }
    
    private static int FastFloor(final float f) {
        return (f >= 0.0f) ? ((int)f) : ((int)f - 1);
    }
    
    private static int FastRound(final float f) {
        return (f >= 0.0f) ? ((int)(f + 0.5f)) : ((int)(f - 0.5f));
    }
    
    private static float Lerp(final float a, final float b, final float t) {
        return a + t * (b - a);
    }
    
    private static float InterpHermite(final float t) {
        return t * t * (3.0f - 2.0f * t);
    }
    
    private static float InterpQuintic(final float t) {
        return t * t * t * (t * (t * 6.0f - 15.0f) + 10.0f);
    }
    
    private static float CubicLerp(final float a, final float b, final float c, final float d, final float t) {
        final float p = d - c - (a - b);
        return t * t * t * p + t * t * (a - b - p) + t * (c - a) + b;
    }
    
    private static float PingPong(float t) {
        t -= (int)(t * 0.5f) * 2;
        return (t < 1.0f) ? t : (2.0f - t);
    }
    
    private void CalculateFractalBounding() {
        float amp;
        final float gain = amp = FastAbs(this.mGain);
        float ampFractal = 1.0f;
        for (int i = 1; i < this.mOctaves; ++i) {
            ampFractal += amp;
            amp *= gain;
        }
        this.mFractalBounding = 1.0f / ampFractal;
    }
    
    private static int Hash(final int seed, final int xPrimed, final int yPrimed) {
        int hash = seed ^ xPrimed ^ yPrimed;
        hash *= 668265261;
        return hash;
    }
    
    private static int Hash(final int seed, final int xPrimed, final int yPrimed, final int zPrimed) {
        int hash = seed ^ xPrimed ^ yPrimed ^ zPrimed;
        hash *= 668265261;
        return hash;
    }
    
    private static float ValCoord(final int seed, final int xPrimed, final int yPrimed) {
        int hash = Hash(seed, xPrimed, yPrimed);
        hash *= hash;
        hash ^= hash << 19;
        return hash * 4.656613E-10f;
    }
    
    private static float ValCoord(final int seed, final int xPrimed, final int yPrimed, final int zPrimed) {
        int hash = Hash(seed, xPrimed, yPrimed, zPrimed);
        hash *= hash;
        hash ^= hash << 19;
        return hash * 4.656613E-10f;
    }
    
    private static float GradCoord(final int seed, final int xPrimed, final int yPrimed, final float xd, final float yd) {
        int hash = Hash(seed, xPrimed, yPrimed);
        hash ^= hash >> 15;
        hash &= 0xFE;
        final float xg = FastNoiseLite.Gradients2D[hash];
        final float yg = FastNoiseLite.Gradients2D[hash | 0x1];
        return xd * xg + yd * yg;
    }
    
    private static float GradCoord(final int seed, final int xPrimed, final int yPrimed, final int zPrimed, final float xd, final float yd, final float zd) {
        int hash = Hash(seed, xPrimed, yPrimed, zPrimed);
        hash ^= hash >> 15;
        hash &= 0xFC;
        final float xg = FastNoiseLite.Gradients3D[hash];
        final float yg = FastNoiseLite.Gradients3D[hash | 0x1];
        final float zg = FastNoiseLite.Gradients3D[hash | 0x2];
        return xd * xg + yd * yg + zd * zg;
    }
    
    private float GenNoiseSingle(final int seed, final float x, final float y) {
        switch (this.mNoiseType) {
            case OpenSimplex2: {
                return this.SingleSimplex(seed, x, y);
            }
            case OpenSimplex2S: {
                return this.SingleOpenSimplex2S(seed, x, y);
            }
            case Cellular: {
                return this.SingleCellular(seed, x, y);
            }
            case Perlin: {
                return this.SinglePerlin(seed, x, y);
            }
            case ValueCubic: {
                return this.SingleValueCubic(seed, x, y);
            }
            case Value: {
                return this.SingleValue(seed, x, y);
            }
            default: {
                return 0.0f;
            }
        }
    }
    
    private float GenNoiseSingle(final int seed, final float x, final float y, final float z) {
        switch (this.mNoiseType) {
            case OpenSimplex2: {
                return this.SingleOpenSimplex2(seed, x, y, z);
            }
            case OpenSimplex2S: {
                return this.SingleOpenSimplex2S(seed, x, y, z);
            }
            case Cellular: {
                return this.SingleCellular(seed, x, y, z);
            }
            case Perlin: {
                return this.SinglePerlin(seed, x, y, z);
            }
            case ValueCubic: {
                return this.SingleValueCubic(seed, x, y, z);
            }
            case Value: {
                return this.SingleValue(seed, x, y, z);
            }
            default: {
                return 0.0f;
            }
        }
    }
    
    private void UpdateTransformType3D() {
        Label_0101: {
            switch (this.mRotationType3D) {
                case ImproveXYPlanes: {
                    this.mTransformType3D = TransformType3D.ImproveXYPlanes;
                    break;
                }
                case ImproveXZPlanes: {
                    this.mTransformType3D = TransformType3D.ImproveXZPlanes;
                    break;
                }
                default: {
                    switch (this.mNoiseType) {
                        case OpenSimplex2:
                        case OpenSimplex2S: {
                            this.mTransformType3D = TransformType3D.DefaultOpenSimplex2;
                            break Label_0101;
                        }
                        default: {
                            this.mTransformType3D = TransformType3D.None;
                            break Label_0101;
                        }
                    }
                }
            }
        }
    }
    
    private void UpdateWarpTransformType3D() {
        Label_0101: {
            switch (this.mRotationType3D) {
                case ImproveXYPlanes: {
                    this.mWarpTransformType3D = TransformType3D.ImproveXYPlanes;
                    break;
                }
                case ImproveXZPlanes: {
                    this.mWarpTransformType3D = TransformType3D.ImproveXZPlanes;
                    break;
                }
                default: {
                    switch (this.mDomainWarpType) {
                        case OpenSimplex2:
                        case OpenSimplex2Reduced: {
                            this.mWarpTransformType3D = TransformType3D.DefaultOpenSimplex2;
                            break Label_0101;
                        }
                        default: {
                            this.mWarpTransformType3D = TransformType3D.None;
                            break Label_0101;
                        }
                    }
                }
            }
        }
    }
    
    private float GenFractalFBm(float x, float y) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; ++i) {
            final float noise = this.GenNoiseSingle(seed++, x, y);
            sum += noise * amp;
            amp *= Lerp(1.0f, FastMin(noise + 1.0f, 2.0f) * 0.5f, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            amp *= this.mGain;
        }
        return sum;
    }
    
    private float GenFractalFBm(float x, float y, float z) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; ++i) {
            final float noise = this.GenNoiseSingle(seed++, x, y, z);
            sum += noise * amp;
            amp *= Lerp(1.0f, (noise + 1.0f) * 0.5f, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            z *= this.mLacunarity;
            amp *= this.mGain;
        }
        return sum;
    }
    
    private float GenFractalRidged(float x, float y) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; ++i) {
            final float noise = FastAbs(this.GenNoiseSingle(seed++, x, y));
            sum += (noise * -2.0f + 1.0f) * amp;
            amp *= Lerp(1.0f, 1.0f - noise, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            amp *= this.mGain;
        }
        return sum;
    }
    
    private float GenFractalRidged(float x, float y, float z) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; ++i) {
            final float noise = FastAbs(this.GenNoiseSingle(seed++, x, y, z));
            sum += (noise * -2.0f + 1.0f) * amp;
            amp *= Lerp(1.0f, 1.0f - noise, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            z *= this.mLacunarity;
            amp *= this.mGain;
        }
        return sum;
    }
    
    private float GenFractalPingPong(float x, float y) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; ++i) {
            final float noise = PingPong((this.GenNoiseSingle(seed++, x, y) + 1.0f) * this.mPingPongStrength);
            sum += (noise - 0.5f) * 2.0f * amp;
            amp *= Lerp(1.0f, noise, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            amp *= this.mGain;
        }
        return sum;
    }
    
    private float GenFractalPingPong(float x, float y, float z) {
        int seed = this.mSeed;
        float sum = 0.0f;
        float amp = this.mFractalBounding;
        for (int i = 0; i < this.mOctaves; ++i) {
            final float noise = PingPong((this.GenNoiseSingle(seed++, x, y, z) + 1.0f) * this.mPingPongStrength);
            sum += (noise - 0.5f) * 2.0f * amp;
            amp *= Lerp(1.0f, noise, this.mWeightedStrength);
            x *= this.mLacunarity;
            y *= this.mLacunarity;
            z *= this.mLacunarity;
            amp *= this.mGain;
        }
        return sum;
    }
    
    private float SingleSimplex(final int seed, final float x, final float y) {
        final float SQRT3 = 1.7320508f;
        final float G2 = 0.21132487f;
        int i = FastFloor(x);
        int j = FastFloor(y);
        final float xi = x - i;
        final float yi = y - j;
        final float t = (xi + yi) * 0.21132487f;
        final float x2 = xi - t;
        final float y2 = yi - t;
        i *= 501125321;
        j *= 1136930381;
        final float a = 0.5f - x2 * x2 - y2 * y2;
        float n0;
        if (a <= 0.0f) {
            n0 = 0.0f;
        }
        else {
            n0 = a * a * (a * a) * GradCoord(seed, i, j, x2, y2);
        }
        final float c = 3.1547005f * t + (-0.6666666f + a);
        float n2;
        if (c <= 0.0f) {
            n2 = 0.0f;
        }
        else {
            final float x3 = x2 - 0.57735026f;
            final float y3 = y2 - 0.57735026f;
            n2 = c * c * (c * c) * GradCoord(seed, i + 501125321, j + 1136930381, x3, y3);
        }
        float n3;
        if (y2 > x2) {
            final float x4 = x2 + 0.21132487f;
            final float y4 = y2 - 0.7886751f;
            final float b = 0.5f - x4 * x4 - y4 * y4;
            if (b <= 0.0f) {
                n3 = 0.0f;
            }
            else {
                n3 = b * b * (b * b) * GradCoord(seed, i, j + 1136930381, x4, y4);
            }
        }
        else {
            final float x4 = x2 - 0.7886751f;
            final float y4 = y2 + 0.21132487f;
            final float b = 0.5f - x4 * x4 - y4 * y4;
            if (b <= 0.0f) {
                n3 = 0.0f;
            }
            else {
                n3 = b * b * (b * b) * GradCoord(seed, i + 501125321, j, x4, y4);
            }
        }
        return (n0 + n3 + n2) * 99.83685f;
    }
    
    private float SingleOpenSimplex2(int seed, final float x, final float y, final float z) {
        int i = FastRound(x);
        int j = FastRound(y);
        int k = FastRound(z);
        float x2 = x - i;
        float y2 = y - j;
        float z2 = z - k;
        int xNSign = (int)(-1.0f - x2) | 0x1;
        int yNSign = (int)(-1.0f - y2) | 0x1;
        int zNSign = (int)(-1.0f - z2) | 0x1;
        float ax0 = xNSign * -x2;
        float ay0 = yNSign * -y2;
        float az0 = zNSign * -z2;
        i *= 501125321;
        j *= 1136930381;
        k *= 1720413743;
        float value = 0.0f;
        float a = 0.6f - x2 * x2 - (y2 * y2 + z2 * z2);
        int l = 0;
        while (true) {
            if (a > 0.0f) {
                value += a * a * (a * a) * GradCoord(seed, i, j, k, x2, y2, z2);
            }
            if (ax0 >= ay0 && ax0 >= az0) {
                float b = a + ax0 + ax0;
                if (b > 1.0f) {
                    --b;
                    value += b * b * (b * b) * GradCoord(seed, i - xNSign * 501125321, j, k, x2 + xNSign, y2, z2);
                }
            }
            else if (ay0 > ax0 && ay0 >= az0) {
                float b = a + ay0 + ay0;
                if (b > 1.0f) {
                    --b;
                    value += b * b * (b * b) * GradCoord(seed, i, j - yNSign * 1136930381, k, x2, y2 + yNSign, z2);
                }
            }
            else {
                float b = a + az0 + az0;
                if (b > 1.0f) {
                    --b;
                    value += b * b * (b * b) * GradCoord(seed, i, j, k - zNSign * 1720413743, x2, y2, z2 + zNSign);
                }
            }
            if (l == 1) {
                break;
            }
            ax0 = 0.5f - ax0;
            ay0 = 0.5f - ay0;
            az0 = 0.5f - az0;
            x2 = xNSign * ax0;
            y2 = yNSign * ay0;
            z2 = zNSign * az0;
            a += 0.75f - ax0 - (ay0 + az0);
            i += (xNSign >> 1 & 0x1DDE90C9);
            j += (yNSign >> 1 & 0x43C42E4D);
            k += (zNSign >> 1 & 0x668B6E2F);
            xNSign = -xNSign;
            yNSign = -yNSign;
            zNSign = -zNSign;
            seed ^= -1;
            ++l;
        }
        return value * 32.694283f;
    }
    
    private float SingleOpenSimplex2S(final int seed, final float x, final float y) {
        final float SQRT3 = 1.7320508f;
        final float G2 = 0.21132487f;
        int i = FastFloor(x);
        int j = FastFloor(y);
        final float xi = x - i;
        final float yi = y - j;
        i *= 501125321;
        j *= 1136930381;
        final int i2 = i + 501125321;
        final int j2 = j + 1136930381;
        final float t = (xi + yi) * 0.21132487f;
        final float x2 = xi - t;
        final float y2 = yi - t;
        final float a0 = 0.6666667f - x2 * x2 - y2 * y2;
        float value = a0 * a0 * (a0 * a0) * GradCoord(seed, i, j, x2, y2);
        final float a2 = 3.1547005f * t + (-0.6666666f + a0);
        final float x3 = x2 - 0.57735026f;
        final float y3 = y2 - 0.57735026f;
        value += a2 * a2 * (a2 * a2) * GradCoord(seed, i2, j2, x3, y3);
        final float xmyi = xi - yi;
        if (t > 0.21132487f) {
            if (xi + xmyi > 1.0f) {
                final float x4 = x2 - 1.3660254f;
                final float y4 = y2 - 0.3660254f;
                final float a3 = 0.6666667f - x4 * x4 - y4 * y4;
                if (a3 > 0.0f) {
                    value += a3 * a3 * (a3 * a3) * GradCoord(seed, i + 1002250642, j + 1136930381, x4, y4);
                }
            }
            else {
                final float x4 = x2 + 0.21132487f;
                final float y4 = y2 - 0.7886751f;
                final float a3 = 0.6666667f - x4 * x4 - y4 * y4;
                if (a3 > 0.0f) {
                    value += a3 * a3 * (a3 * a3) * GradCoord(seed, i, j + 1136930381, x4, y4);
                }
            }
            if (yi - xmyi > 1.0f) {
                final float x5 = x2 - 0.3660254f;
                final float y5 = y2 - 1.3660254f;
                final float a4 = 0.6666667f - x5 * x5 - y5 * y5;
                if (a4 > 0.0f) {
                    value += a4 * a4 * (a4 * a4) * GradCoord(seed, i + 501125321, j - 2021106534, x5, y5);
                }
            }
            else {
                final float x5 = x2 - 0.7886751f;
                final float y5 = y2 + 0.21132487f;
                final float a4 = 0.6666667f - x5 * x5 - y5 * y5;
                if (a4 > 0.0f) {
                    value += a4 * a4 * (a4 * a4) * GradCoord(seed, i + 501125321, j, x5, y5);
                }
            }
        }
        else {
            if (xi + xmyi < 0.0f) {
                final float x4 = x2 + 0.7886751f;
                final float y4 = y2 - 0.21132487f;
                final float a3 = 0.6666667f - x4 * x4 - y4 * y4;
                if (a3 > 0.0f) {
                    value += a3 * a3 * (a3 * a3) * GradCoord(seed, i - 501125321, j, x4, y4);
                }
            }
            else {
                final float x4 = x2 - 0.7886751f;
                final float y4 = y2 + 0.21132487f;
                final float a3 = 0.6666667f - x4 * x4 - y4 * y4;
                if (a3 > 0.0f) {
                    value += a3 * a3 * (a3 * a3) * GradCoord(seed, i + 501125321, j, x4, y4);
                }
            }
            if (yi < xmyi) {
                final float x4 = x2 - 0.21132487f;
                final float y4 = y2 + 0.7886751f;
                final float a3 = 0.6666667f - x4 * x4 - y4 * y4;
                if (a3 > 0.0f) {
                    value += a3 * a3 * (a3 * a3) * GradCoord(seed, i, j - 1136930381, x4, y4);
                }
            }
            else {
                final float x4 = x2 + 0.21132487f;
                final float y4 = y2 - 0.7886751f;
                final float a3 = 0.6666667f - x4 * x4 - y4 * y4;
                if (a3 > 0.0f) {
                    value += a3 * a3 * (a3 * a3) * GradCoord(seed, i, j + 1136930381, x4, y4);
                }
            }
        }
        return value * 18.241962f;
    }
    
    private float SingleOpenSimplex2S(final int seed, final float x, final float y, final float z) {
        int i = FastFloor(x);
        int j = FastFloor(y);
        int k = FastFloor(z);
        final float xi = x - i;
        final float yi = y - j;
        final float zi = z - k;
        i *= 501125321;
        j *= 1136930381;
        k *= 1720413743;
        final int seed2 = seed + 1293373;
        final int xNMask = (int)(-0.5f - xi);
        final int yNMask = (int)(-0.5f - yi);
        final int zNMask = (int)(-0.5f - zi);
        final float x2 = xi + xNMask;
        final float y2 = yi + yNMask;
        final float z2 = zi + zNMask;
        final float a0 = 0.75f - x2 * x2 - y2 * y2 - z2 * z2;
        float value = a0 * a0 * (a0 * a0) * GradCoord(seed, i + (xNMask & 0x1DDE90C9), j + (yNMask & 0x43C42E4D), k + (zNMask & 0x668B6E2F), x2, y2, z2);
        final float x3 = xi - 0.5f;
        final float y3 = yi - 0.5f;
        final float z3 = zi - 0.5f;
        final float a2 = 0.75f - x3 * x3 - y3 * y3 - z3 * z3;
        value += a2 * a2 * (a2 * a2) * GradCoord(seed2, i + 501125321, j + 1136930381, k + 1720413743, x3, y3, z3);
        final float xAFlipMask0 = ((xNMask | 0x1) << 1) * x3;
        final float yAFlipMask0 = ((yNMask | 0x1) << 1) * y3;
        final float zAFlipMask0 = ((zNMask | 0x1) << 1) * z3;
        final float xAFlipMask2 = (-2 - (xNMask << 2)) * x3 - 1.0f;
        final float yAFlipMask2 = (-2 - (yNMask << 2)) * y3 - 1.0f;
        final float zAFlipMask2 = (-2 - (zNMask << 2)) * z3 - 1.0f;
        boolean skip5 = false;
        final float a3 = xAFlipMask0 + a0;
        if (a3 > 0.0f) {
            final float x4 = x2 - (xNMask | 0x1);
            final float y4 = y2;
            final float z4 = z2;
            value += a3 * a3 * (a3 * a3) * GradCoord(seed, i + (~xNMask & 0x1DDE90C9), j + (yNMask & 0x43C42E4D), k + (zNMask & 0x668B6E2F), x4, y4, z4);
        }
        else {
            final float a4 = yAFlipMask0 + zAFlipMask0 + a0;
            if (a4 > 0.0f) {
                final float x5 = x2;
                final float y5 = y2 - (yNMask | 0x1);
                final float z5 = z2 - (zNMask | 0x1);
                value += a4 * a4 * (a4 * a4) * GradCoord(seed, i + (xNMask & 0x1DDE90C9), j + (~yNMask & 0x43C42E4D), k + (~zNMask & 0x668B6E2F), x5, y5, z5);
            }
            final float a5 = xAFlipMask2 + a2;
            if (a5 > 0.0f) {
                final float x6 = (xNMask | 0x1) + x3;
                final float y6 = y3;
                final float z6 = z3;
                value += a5 * a5 * (a5 * a5) * GradCoord(seed2, i + (xNMask & 0x3BBD2192), j + 1136930381, k + 1720413743, x6, y6, z6);
                skip5 = true;
            }
        }
        boolean skip6 = false;
        final float a6 = yAFlipMask0 + a0;
        if (a6 > 0.0f) {
            final float x7 = x2;
            final float y7 = y2 - (yNMask | 0x1);
            final float z7 = z2;
            value += a6 * a6 * (a6 * a6) * GradCoord(seed, i + (xNMask & 0x1DDE90C9), j + (~yNMask & 0x43C42E4D), k + (zNMask & 0x668B6E2F), x7, y7, z7);
        }
        else {
            final float a7 = xAFlipMask0 + zAFlipMask0 + a0;
            if (a7 > 0.0f) {
                final float x8 = x2 - (xNMask | 0x1);
                final float y8 = y2;
                final float z8 = z2 - (zNMask | 0x1);
                value += a7 * a7 * (a7 * a7) * GradCoord(seed, i + (~xNMask & 0x1DDE90C9), j + (yNMask & 0x43C42E4D), k + (~zNMask & 0x668B6E2F), x8, y8, z8);
            }
            final float a8 = yAFlipMask2 + a2;
            if (a8 > 0.0f) {
                final float x9 = x3;
                final float y9 = (yNMask | 0x1) + y3;
                final float z9 = z3;
                value += a8 * a8 * (a8 * a8) * GradCoord(seed2, i + 501125321, j + (yNMask & 0x87885C9A), k + 1720413743, x9, y9, z9);
                skip6 = true;
            }
        }
        boolean skipD = false;
        final float aA = zAFlipMask0 + a0;
        if (aA > 0.0f) {
            final float xA = x2;
            final float yA = y2;
            final float zA = z2 - (zNMask | 0x1);
            value += aA * aA * (aA * aA) * GradCoord(seed, i + (xNMask & 0x1DDE90C9), j + (yNMask & 0x43C42E4D), k + (~zNMask & 0x668B6E2F), xA, yA, zA);
        }
        else {
            final float aB = xAFlipMask0 + yAFlipMask0 + a0;
            if (aB > 0.0f) {
                final float xB = x2 - (xNMask | 0x1);
                final float yB = y2 - (yNMask | 0x1);
                final float zB = z2;
                value += aB * aB * (aB * aB) * GradCoord(seed, i + (~xNMask & 0x1DDE90C9), j + (~yNMask & 0x43C42E4D), k + (zNMask & 0x668B6E2F), xB, yB, zB);
            }
            final float aC = zAFlipMask2 + a2;
            if (aC > 0.0f) {
                final float xC = x3;
                final float yC = y3;
                final float zC = (zNMask | 0x1) + z3;
                value += aC * aC * (aC * aC) * GradCoord(seed2, i + 501125321, j + 1136930381, k + (zNMask & 0xCD16DC5E), xC, yC, zC);
                skipD = true;
            }
        }
        if (!skip5) {
            final float a9 = yAFlipMask2 + zAFlipMask2 + a2;
            if (a9 > 0.0f) {
                final float x10 = x3;
                final float y10 = (yNMask | 0x1) + y3;
                final float z10 = (zNMask | 0x1) + z3;
                value += a9 * a9 * (a9 * a9) * GradCoord(seed2, i + 501125321, j + (yNMask & 0x87885C9A), k + (zNMask & 0xCD16DC5E), x10, y10, z10);
            }
        }
        if (!skip6) {
            final float a10 = xAFlipMask2 + zAFlipMask2 + a2;
            if (a10 > 0.0f) {
                final float x11 = (xNMask | 0x1) + x3;
                final float y11 = y3;
                final float z11 = (zNMask | 0x1) + z3;
                value += a10 * a10 * (a10 * a10) * GradCoord(seed2, i + (xNMask & 0x3BBD2192), j + 1136930381, k + (zNMask & 0xCD16DC5E), x11, y11, z11);
            }
        }
        if (!skipD) {
            final float aD = xAFlipMask2 + yAFlipMask2 + a2;
            if (aD > 0.0f) {
                final float xD = (xNMask | 0x1) + x3;
                final float yD = (yNMask | 0x1) + y3;
                final float zD = z3;
                value += aD * aD * (aD * aD) * GradCoord(seed2, i + (xNMask & 0x3BBD2192), j + (yNMask & 0x87885C9A), k + 1720413743, xD, yD, zD);
            }
        }
        return value * 9.046026f;
    }
    
    private float SingleCellular(final int seed, final float x, final float y) {
        final int xr = FastRound(x);
        final int yr = FastRound(y);
        float distance0 = Float.MAX_VALUE;
        float distance2 = Float.MAX_VALUE;
        int closestHash = 0;
        final float cellularJitter = 0.43701595f * this.mCellularJitterModifier;
        int xPrimed = (xr - 1) * 501125321;
        final int yPrimedBase = (yr - 1) * 1136930381;
        switch (this.mCellularDistanceFunction) {
            default: {
                for (int xi = xr - 1; xi <= xr + 1; ++xi) {
                    int yPrimed = yPrimedBase;
                    for (int yi = yr - 1; yi <= yr + 1; ++yi) {
                        final int hash = Hash(seed, xPrimed, yPrimed);
                        final int idx = hash & 0x1FE;
                        final float vecX = xi - x + FastNoiseLite.RandVecs2D[idx] * cellularJitter;
                        final float vecY = yi - y + FastNoiseLite.RandVecs2D[idx | 0x1] * cellularJitter;
                        final float newDistance = vecX * vecX + vecY * vecY;
                        distance2 = FastMax(FastMin(distance2, newDistance), distance0);
                        if (newDistance < distance0) {
                            distance0 = newDistance;
                            closestHash = hash;
                        }
                        yPrimed += 1136930381;
                    }
                    xPrimed += 501125321;
                }
                break;
            }
            case Manhattan: {
                for (int xi = xr - 1; xi <= xr + 1; ++xi) {
                    int yPrimed = yPrimedBase;
                    for (int yi = yr - 1; yi <= yr + 1; ++yi) {
                        final int hash = Hash(seed, xPrimed, yPrimed);
                        final int idx = hash & 0x1FE;
                        final float vecX = xi - x + FastNoiseLite.RandVecs2D[idx] * cellularJitter;
                        final float vecY = yi - y + FastNoiseLite.RandVecs2D[idx | 0x1] * cellularJitter;
                        final float newDistance = FastAbs(vecX) + FastAbs(vecY);
                        distance2 = FastMax(FastMin(distance2, newDistance), distance0);
                        if (newDistance < distance0) {
                            distance0 = newDistance;
                            closestHash = hash;
                        }
                        yPrimed += 1136930381;
                    }
                    xPrimed += 501125321;
                }
                break;
            }
            case Hybrid: {
                for (int xi = xr - 1; xi <= xr + 1; ++xi) {
                    int yPrimed = yPrimedBase;
                    for (int yi = yr - 1; yi <= yr + 1; ++yi) {
                        final int hash = Hash(seed, xPrimed, yPrimed);
                        final int idx = hash & 0x1FE;
                        final float vecX = xi - x + FastNoiseLite.RandVecs2D[idx] * cellularJitter;
                        final float vecY = yi - y + FastNoiseLite.RandVecs2D[idx | 0x1] * cellularJitter;
                        final float newDistance = FastAbs(vecX) + FastAbs(vecY) + (vecX * vecX + vecY * vecY);
                        distance2 = FastMax(FastMin(distance2, newDistance), distance0);
                        if (newDistance < distance0) {
                            distance0 = newDistance;
                            closestHash = hash;
                        }
                        yPrimed += 1136930381;
                    }
                    xPrimed += 501125321;
                }
                break;
            }
        }
        if (this.mCellularDistanceFunction == CellularDistanceFunction.Euclidean && this.mCellularReturnType != CellularReturnType.CellValue) {
            distance0 = FastSqrt(distance0);
            if (this.mCellularReturnType != CellularReturnType.Distance) {
                distance2 = FastSqrt(distance2);
            }
        }
        switch (this.mCellularReturnType) {
            case CellValue: {
                return closestHash * 4.656613E-10f;
            }
            case Distance: {
                return distance0 - 1.0f;
            }
            case Distance2: {
                return distance2 - 1.0f;
            }
            case Distance2Add: {
                return (distance2 + distance0) * 0.5f - 1.0f;
            }
            case Distance2Sub: {
                return distance2 - distance0 - 1.0f;
            }
            case Distance2Mul: {
                return distance2 * distance0 * 0.5f - 1.0f;
            }
            case Distance2Div: {
                return distance0 / distance2 - 1.0f;
            }
            default: {
                return 0.0f;
            }
        }
    }
    
    private float SingleCellular(final int seed, final float x, final float y, final float z) {
        final int xr = FastRound(x);
        final int yr = FastRound(y);
        final int zr = FastRound(z);
        float distance0 = Float.MAX_VALUE;
        float distance2 = Float.MAX_VALUE;
        int closestHash = 0;
        final float cellularJitter = 0.39614353f * this.mCellularJitterModifier;
        int xPrimed = (xr - 1) * 501125321;
        final int yPrimedBase = (yr - 1) * 1136930381;
        final int zPrimedBase = (zr - 1) * 1720413743;
        switch (this.mCellularDistanceFunction) {
            case Euclidean:
            case EuclideanSq: {
                for (int xi = xr - 1; xi <= xr + 1; ++xi) {
                    int yPrimed = yPrimedBase;
                    for (int yi = yr - 1; yi <= yr + 1; ++yi) {
                        int zPrimed = zPrimedBase;
                        for (int zi = zr - 1; zi <= zr + 1; ++zi) {
                            final int hash = Hash(seed, xPrimed, yPrimed, zPrimed);
                            final int idx = hash & 0x3FC;
                            final float vecX = xi - x + FastNoiseLite.RandVecs3D[idx] * cellularJitter;
                            final float vecY = yi - y + FastNoiseLite.RandVecs3D[idx | 0x1] * cellularJitter;
                            final float vecZ = zi - z + FastNoiseLite.RandVecs3D[idx | 0x2] * cellularJitter;
                            final float newDistance = vecX * vecX + vecY * vecY + vecZ * vecZ;
                            distance2 = FastMax(FastMin(distance2, newDistance), distance0);
                            if (newDistance < distance0) {
                                distance0 = newDistance;
                                closestHash = hash;
                            }
                            zPrimed += 1720413743;
                        }
                        yPrimed += 1136930381;
                    }
                    xPrimed += 501125321;
                }
                break;
            }
            case Manhattan: {
                for (int xi = xr - 1; xi <= xr + 1; ++xi) {
                    int yPrimed = yPrimedBase;
                    for (int yi = yr - 1; yi <= yr + 1; ++yi) {
                        int zPrimed = zPrimedBase;
                        for (int zi = zr - 1; zi <= zr + 1; ++zi) {
                            final int hash = Hash(seed, xPrimed, yPrimed, zPrimed);
                            final int idx = hash & 0x3FC;
                            final float vecX = xi - x + FastNoiseLite.RandVecs3D[idx] * cellularJitter;
                            final float vecY = yi - y + FastNoiseLite.RandVecs3D[idx | 0x1] * cellularJitter;
                            final float vecZ = zi - z + FastNoiseLite.RandVecs3D[idx | 0x2] * cellularJitter;
                            final float newDistance = FastAbs(vecX) + FastAbs(vecY) + FastAbs(vecZ);
                            distance2 = FastMax(FastMin(distance2, newDistance), distance0);
                            if (newDistance < distance0) {
                                distance0 = newDistance;
                                closestHash = hash;
                            }
                            zPrimed += 1720413743;
                        }
                        yPrimed += 1136930381;
                    }
                    xPrimed += 501125321;
                }
                break;
            }
            case Hybrid: {
                for (int xi = xr - 1; xi <= xr + 1; ++xi) {
                    int yPrimed = yPrimedBase;
                    for (int yi = yr - 1; yi <= yr + 1; ++yi) {
                        int zPrimed = zPrimedBase;
                        for (int zi = zr - 1; zi <= zr + 1; ++zi) {
                            final int hash = Hash(seed, xPrimed, yPrimed, zPrimed);
                            final int idx = hash & 0x3FC;
                            final float vecX = xi - x + FastNoiseLite.RandVecs3D[idx] * cellularJitter;
                            final float vecY = yi - y + FastNoiseLite.RandVecs3D[idx | 0x1] * cellularJitter;
                            final float vecZ = zi - z + FastNoiseLite.RandVecs3D[idx | 0x2] * cellularJitter;
                            final float newDistance = FastAbs(vecX) + FastAbs(vecY) + FastAbs(vecZ) + (vecX * vecX + vecY * vecY + vecZ * vecZ);
                            distance2 = FastMax(FastMin(distance2, newDistance), distance0);
                            if (newDistance < distance0) {
                                distance0 = newDistance;
                                closestHash = hash;
                            }
                            zPrimed += 1720413743;
                        }
                        yPrimed += 1136930381;
                    }
                    xPrimed += 501125321;
                }
                break;
            }
        }
        if (this.mCellularDistanceFunction == CellularDistanceFunction.Euclidean && this.mCellularReturnType != CellularReturnType.CellValue) {
            distance0 = FastSqrt(distance0);
            if (this.mCellularReturnType != CellularReturnType.Distance) {
                distance2 = FastSqrt(distance2);
            }
        }
        switch (this.mCellularReturnType) {
            case CellValue: {
                return closestHash * 4.656613E-10f;
            }
            case Distance: {
                return distance0 - 1.0f;
            }
            case Distance2: {
                return distance2 - 1.0f;
            }
            case Distance2Add: {
                return (distance2 + distance0) * 0.5f - 1.0f;
            }
            case Distance2Sub: {
                return distance2 - distance0 - 1.0f;
            }
            case Distance2Mul: {
                return distance2 * distance0 * 0.5f - 1.0f;
            }
            case Distance2Div: {
                return distance0 / distance2 - 1.0f;
            }
            default: {
                return 0.0f;
            }
        }
    }
    
    private float SinglePerlin(final int seed, final float x, final float y) {
        int x2 = FastFloor(x);
        int y2 = FastFloor(y);
        final float xd0 = x - x2;
        final float yd0 = y - y2;
        final float xd2 = xd0 - 1.0f;
        final float yd2 = yd0 - 1.0f;
        final float xs = InterpQuintic(xd0);
        final float ys = InterpQuintic(yd0);
        x2 *= 501125321;
        y2 *= 1136930381;
        final int x3 = x2 + 501125321;
        final int y3 = y2 + 1136930381;
        final float xf0 = Lerp(GradCoord(seed, x2, y2, xd0, yd0), GradCoord(seed, x3, y2, xd2, yd0), xs);
        final float xf2 = Lerp(GradCoord(seed, x2, y3, xd0, yd2), GradCoord(seed, x3, y3, xd2, yd2), xs);
        return Lerp(xf0, xf2, ys) * 1.4247692f;
    }
    
    private float SinglePerlin(final int seed, final float x, final float y, final float z) {
        int x2 = FastFloor(x);
        int y2 = FastFloor(y);
        int z2 = FastFloor(z);
        final float xd0 = x - x2;
        final float yd0 = y - y2;
        final float zd0 = z - z2;
        final float xd2 = xd0 - 1.0f;
        final float yd2 = yd0 - 1.0f;
        final float zd2 = zd0 - 1.0f;
        final float xs = InterpQuintic(xd0);
        final float ys = InterpQuintic(yd0);
        final float zs = InterpQuintic(zd0);
        x2 *= 501125321;
        y2 *= 1136930381;
        z2 *= 1720413743;
        final int x3 = x2 + 501125321;
        final int y3 = y2 + 1136930381;
        final int z3 = z2 + 1720413743;
        final float xf00 = Lerp(GradCoord(seed, x2, y2, z2, xd0, yd0, zd0), GradCoord(seed, x3, y2, z2, xd2, yd0, zd0), xs);
        final float xf2 = Lerp(GradCoord(seed, x2, y3, z2, xd0, yd2, zd0), GradCoord(seed, x3, y3, z2, xd2, yd2, zd0), xs);
        final float xf3 = Lerp(GradCoord(seed, x2, y2, z3, xd0, yd0, zd2), GradCoord(seed, x3, y2, z3, xd2, yd0, zd2), xs);
        final float xf4 = Lerp(GradCoord(seed, x2, y3, z3, xd0, yd2, zd2), GradCoord(seed, x3, y3, z3, xd2, yd2, zd2), xs);
        final float yf0 = Lerp(xf00, xf2, ys);
        final float yf2 = Lerp(xf3, xf4, ys);
        return Lerp(yf0, yf2, zs) * 0.9649214f;
    }
    
    private float SingleValueCubic(final int seed, final float x, final float y) {
        int x2 = FastFloor(x);
        int y2 = FastFloor(y);
        final float xs = x - x2;
        final float ys = y - y2;
        x2 *= 501125321;
        y2 *= 1136930381;
        final int x3 = x2 - 501125321;
        final int y3 = y2 - 1136930381;
        final int x4 = x2 + 501125321;
        final int y4 = y2 + 1136930381;
        final int x5 = x2 + 1002250642;
        final int y5 = y2 - 2021106534;
        return CubicLerp(CubicLerp(ValCoord(seed, x3, y3), ValCoord(seed, x2, y3), ValCoord(seed, x4, y3), ValCoord(seed, x5, y3), xs), CubicLerp(ValCoord(seed, x3, y2), ValCoord(seed, x2, y2), ValCoord(seed, x4, y2), ValCoord(seed, x5, y2), xs), CubicLerp(ValCoord(seed, x3, y4), ValCoord(seed, x2, y4), ValCoord(seed, x4, y4), ValCoord(seed, x5, y4), xs), CubicLerp(ValCoord(seed, x3, y5), ValCoord(seed, x2, y5), ValCoord(seed, x4, y5), ValCoord(seed, x5, y5), xs), ys) * 0.44444445f;
    }
    
    private float SingleValueCubic(final int seed, final float x, final float y, final float z) {
        int x2 = FastFloor(x);
        int y2 = FastFloor(y);
        int z2 = FastFloor(z);
        final float xs = x - x2;
        final float ys = y - y2;
        final float zs = z - z2;
        x2 *= 501125321;
        y2 *= 1136930381;
        z2 *= 1720413743;
        final int x3 = x2 - 501125321;
        final int y3 = y2 - 1136930381;
        final int z3 = z2 - 1720413743;
        final int x4 = x2 + 501125321;
        final int y4 = y2 + 1136930381;
        final int z4 = z2 + 1720413743;
        final int x5 = x2 + 1002250642;
        final int y5 = y2 - 2021106534;
        final int z5 = z2 - 854139810;
        return CubicLerp(CubicLerp(CubicLerp(ValCoord(seed, x3, y3, z3), ValCoord(seed, x2, y3, z3), ValCoord(seed, x4, y3, z3), ValCoord(seed, x5, y3, z3), xs), CubicLerp(ValCoord(seed, x3, y2, z3), ValCoord(seed, x2, y2, z3), ValCoord(seed, x4, y2, z3), ValCoord(seed, x5, y2, z3), xs), CubicLerp(ValCoord(seed, x3, y4, z3), ValCoord(seed, x2, y4, z3), ValCoord(seed, x4, y4, z3), ValCoord(seed, x5, y4, z3), xs), CubicLerp(ValCoord(seed, x3, y5, z3), ValCoord(seed, x2, y5, z3), ValCoord(seed, x4, y5, z3), ValCoord(seed, x5, y5, z3), xs), ys), CubicLerp(CubicLerp(ValCoord(seed, x3, y3, z2), ValCoord(seed, x2, y3, z2), ValCoord(seed, x4, y3, z2), ValCoord(seed, x5, y3, z2), xs), CubicLerp(ValCoord(seed, x3, y2, z2), ValCoord(seed, x2, y2, z2), ValCoord(seed, x4, y2, z2), ValCoord(seed, x5, y2, z2), xs), CubicLerp(ValCoord(seed, x3, y4, z2), ValCoord(seed, x2, y4, z2), ValCoord(seed, x4, y4, z2), ValCoord(seed, x5, y4, z2), xs), CubicLerp(ValCoord(seed, x3, y5, z2), ValCoord(seed, x2, y5, z2), ValCoord(seed, x4, y5, z2), ValCoord(seed, x5, y5, z2), xs), ys), CubicLerp(CubicLerp(ValCoord(seed, x3, y3, z4), ValCoord(seed, x2, y3, z4), ValCoord(seed, x4, y3, z4), ValCoord(seed, x5, y3, z4), xs), CubicLerp(ValCoord(seed, x3, y2, z4), ValCoord(seed, x2, y2, z4), ValCoord(seed, x4, y2, z4), ValCoord(seed, x5, y2, z4), xs), CubicLerp(ValCoord(seed, x3, y4, z4), ValCoord(seed, x2, y4, z4), ValCoord(seed, x4, y4, z4), ValCoord(seed, x5, y4, z4), xs), CubicLerp(ValCoord(seed, x3, y5, z4), ValCoord(seed, x2, y5, z4), ValCoord(seed, x4, y5, z4), ValCoord(seed, x5, y5, z4), xs), ys), CubicLerp(CubicLerp(ValCoord(seed, x3, y3, z5), ValCoord(seed, x2, y3, z5), ValCoord(seed, x4, y3, z5), ValCoord(seed, x5, y3, z5), xs), CubicLerp(ValCoord(seed, x3, y2, z5), ValCoord(seed, x2, y2, z5), ValCoord(seed, x4, y2, z5), ValCoord(seed, x5, y2, z5), xs), CubicLerp(ValCoord(seed, x3, y4, z5), ValCoord(seed, x2, y4, z5), ValCoord(seed, x4, y4, z5), ValCoord(seed, x5, y4, z5), xs), CubicLerp(ValCoord(seed, x3, y5, z5), ValCoord(seed, x2, y5, z5), ValCoord(seed, x4, y5, z5), ValCoord(seed, x5, y5, z5), xs), ys), zs) * 0.2962963f;
    }
    
    private float SingleValue(final int seed, final float x, final float y) {
        int x2 = FastFloor(x);
        int y2 = FastFloor(y);
        final float xs = InterpHermite(x - x2);
        final float ys = InterpHermite(y - y2);
        x2 *= 501125321;
        y2 *= 1136930381;
        final int x3 = x2 + 501125321;
        final int y3 = y2 + 1136930381;
        final float xf0 = Lerp(ValCoord(seed, x2, y2), ValCoord(seed, x3, y2), xs);
        final float xf2 = Lerp(ValCoord(seed, x2, y3), ValCoord(seed, x3, y3), xs);
        return Lerp(xf0, xf2, ys);
    }
    
    private float SingleValue(final int seed, final float x, final float y, final float z) {
        int x2 = FastFloor(x);
        int y2 = FastFloor(y);
        int z2 = FastFloor(z);
        final float xs = InterpHermite(x - x2);
        final float ys = InterpHermite(y - y2);
        final float zs = InterpHermite(z - z2);
        x2 *= 501125321;
        y2 *= 1136930381;
        z2 *= 1720413743;
        final int x3 = x2 + 501125321;
        final int y3 = y2 + 1136930381;
        final int z3 = z2 + 1720413743;
        final float xf00 = Lerp(ValCoord(seed, x2, y2, z2), ValCoord(seed, x3, y2, z2), xs);
        final float xf2 = Lerp(ValCoord(seed, x2, y3, z2), ValCoord(seed, x3, y3, z2), xs);
        final float xf3 = Lerp(ValCoord(seed, x2, y2, z3), ValCoord(seed, x3, y2, z3), xs);
        final float xf4 = Lerp(ValCoord(seed, x2, y3, z3), ValCoord(seed, x3, y3, z3), xs);
        final float yf0 = Lerp(xf00, xf2, ys);
        final float yf2 = Lerp(xf3, xf4, ys);
        return Lerp(yf0, yf2, zs);
    }
    
    private void DoSingleDomainWarp(final int seed, final float amp, final float freq, final float x, final float y, final Vector2 coord) {
        switch (this.mDomainWarpType) {
            case OpenSimplex2: {
                this.SingleDomainWarpSimplexGradient(seed, amp * 38.283688f, freq, x, y, coord, false);
                break;
            }
            case OpenSimplex2Reduced: {
                this.SingleDomainWarpSimplexGradient(seed, amp * 16.0f, freq, x, y, coord, true);
                break;
            }
            case BasicGrid: {
                this.SingleDomainWarpBasicGrid(seed, amp, freq, x, y, coord);
                break;
            }
        }
    }
    
    private void DoSingleDomainWarp(final int seed, final float amp, final float freq, final float x, final float y, final float z, final Vector3 coord) {
        switch (this.mDomainWarpType) {
            case OpenSimplex2: {
                this.SingleDomainWarpOpenSimplex2Gradient(seed, amp * 32.694283f, freq, x, y, z, coord, false);
                break;
            }
            case OpenSimplex2Reduced: {
                this.SingleDomainWarpOpenSimplex2Gradient(seed, amp * 7.716049f, freq, x, y, z, coord, true);
                break;
            }
            case BasicGrid: {
                this.SingleDomainWarpBasicGrid(seed, amp, freq, x, y, z, coord);
                break;
            }
        }
    }
    
    private void DomainWarpSingle(final Vector2 coord) {
        final int seed = this.mSeed;
        final float amp = this.mDomainWarpAmp * this.mFractalBounding;
        final float freq = this.mFrequency;
        float xs = coord.x;
        float ys = coord.y;
        switch (this.mDomainWarpType) {
            case OpenSimplex2:
            case OpenSimplex2Reduced: {
                final float SQRT3 = 1.7320508f;
                final float F2 = 0.3660254f;
                final float t = (xs + ys) * 0.3660254f;
                xs += t;
                ys += t;
                break;
            }
        }
        this.DoSingleDomainWarp(seed, amp, freq, xs, ys, coord);
    }
    
    private void DomainWarpSingle(final Vector3 coord) {
        final int seed = this.mSeed;
        final float amp = this.mDomainWarpAmp * this.mFractalBounding;
        final float freq = this.mFrequency;
        float xs = coord.x;
        float ys = coord.y;
        float zs = coord.z;
        switch (this.mWarpTransformType3D) {
            case ImproveXYPlanes: {
                final float xy = xs + ys;
                final float s2 = xy * -0.21132487f;
                zs *= 0.57735026f;
                xs += s2 - zs;
                ys = ys + s2 - zs;
                zs += xy * 0.57735026f;
                break;
            }
            case ImproveXZPlanes: {
                final float xz = xs + zs;
                final float s2 = xz * -0.21132487f;
                ys *= 0.57735026f;
                xs += s2 - ys;
                zs += s2 - ys;
                ys += xz * 0.57735026f;
                break;
            }
            case DefaultOpenSimplex2: {
                final float R3 = 0.6666667f;
                final float r = (xs + ys + zs) * 0.6666667f;
                xs = r - xs;
                ys = r - ys;
                zs = r - zs;
                break;
            }
        }
        this.DoSingleDomainWarp(seed, amp, freq, xs, ys, zs, coord);
    }
    
    private void DomainWarpFractalProgressive(final Vector2 coord) {
        int seed = this.mSeed;
        float amp = this.mDomainWarpAmp * this.mFractalBounding;
        float freq = this.mFrequency;
        for (int i = 0; i < this.mOctaves; ++i) {
            float xs = coord.x;
            float ys = coord.y;
            switch (this.mDomainWarpType) {
                case OpenSimplex2:
                case OpenSimplex2Reduced: {
                    final float SQRT3 = 1.7320508f;
                    final float F2 = 0.3660254f;
                    final float t = (xs + ys) * 0.3660254f;
                    xs += t;
                    ys += t;
                    break;
                }
            }
            this.DoSingleDomainWarp(seed, amp, freq, xs, ys, coord);
            ++seed;
            amp *= this.mGain;
            freq *= this.mLacunarity;
        }
    }
    
    private void DomainWarpFractalProgressive(final Vector3 coord) {
        int seed = this.mSeed;
        float amp = this.mDomainWarpAmp * this.mFractalBounding;
        float freq = this.mFrequency;
        for (int i = 0; i < this.mOctaves; ++i) {
            float xs = coord.x;
            float ys = coord.y;
            float zs = coord.z;
            switch (this.mWarpTransformType3D) {
                case ImproveXYPlanes: {
                    final float xy = xs + ys;
                    final float s2 = xy * -0.21132487f;
                    zs *= 0.57735026f;
                    xs += s2 - zs;
                    ys = ys + s2 - zs;
                    zs += xy * 0.57735026f;
                    break;
                }
                case ImproveXZPlanes: {
                    final float xz = xs + zs;
                    final float s2 = xz * -0.21132487f;
                    ys *= 0.57735026f;
                    xs += s2 - ys;
                    zs += s2 - ys;
                    ys += xz * 0.57735026f;
                    break;
                }
                case DefaultOpenSimplex2: {
                    final float R3 = 0.6666667f;
                    final float r = (xs + ys + zs) * 0.6666667f;
                    xs = r - xs;
                    ys = r - ys;
                    zs = r - zs;
                    break;
                }
            }
            this.DoSingleDomainWarp(seed, amp, freq, xs, ys, zs, coord);
            ++seed;
            amp *= this.mGain;
            freq *= this.mLacunarity;
        }
    }
    
    private void DomainWarpFractalIndependent(final Vector2 coord) {
        float xs = coord.x;
        float ys = coord.y;
        switch (this.mDomainWarpType) {
            case OpenSimplex2:
            case OpenSimplex2Reduced: {
                final float SQRT3 = 1.7320508f;
                final float F2 = 0.3660254f;
                final float t = (xs + ys) * 0.3660254f;
                xs += t;
                ys += t;
                break;
            }
        }
        int seed = this.mSeed;
        float amp = this.mDomainWarpAmp * this.mFractalBounding;
        float freq = this.mFrequency;
        for (int i = 0; i < this.mOctaves; ++i) {
            this.DoSingleDomainWarp(seed, amp, freq, xs, ys, coord);
            ++seed;
            amp *= this.mGain;
            freq *= this.mLacunarity;
        }
    }
    
    private void DomainWarpFractalIndependent(final Vector3 coord) {
        float xs = coord.x;
        float ys = coord.y;
        float zs = coord.z;
        switch (this.mWarpTransformType3D) {
            case ImproveXYPlanes: {
                final float xy = xs + ys;
                final float s2 = xy * -0.21132487f;
                zs *= 0.57735026f;
                xs += s2 - zs;
                ys = ys + s2 - zs;
                zs += xy * 0.57735026f;
                break;
            }
            case ImproveXZPlanes: {
                final float xz = xs + zs;
                final float s2 = xz * -0.21132487f;
                ys *= 0.57735026f;
                xs += s2 - ys;
                zs += s2 - ys;
                ys += xz * 0.57735026f;
                break;
            }
            case DefaultOpenSimplex2: {
                final float R3 = 0.6666667f;
                final float r = (xs + ys + zs) * 0.6666667f;
                xs = r - xs;
                ys = r - ys;
                zs = r - zs;
                break;
            }
        }
        int seed = this.mSeed;
        float amp = this.mDomainWarpAmp * this.mFractalBounding;
        float freq = this.mFrequency;
        for (int i = 0; i < this.mOctaves; ++i) {
            this.DoSingleDomainWarp(seed, amp, freq, xs, ys, zs, coord);
            ++seed;
            amp *= this.mGain;
            freq *= this.mLacunarity;
        }
    }
    
    private void SingleDomainWarpBasicGrid(final int seed, final float warpAmp, final float frequency, final float x, final float y, final Vector2 coord) {
        final float xf = x * frequency;
        final float yf = y * frequency;
        int x2 = FastFloor(xf);
        int y2 = FastFloor(yf);
        final float xs = InterpHermite(xf - x2);
        final float ys = InterpHermite(yf - y2);
        x2 *= 501125321;
        y2 *= 1136930381;
        final int x3 = x2 + 501125321;
        final int y3 = y2 + 1136930381;
        int hash0 = Hash(seed, x2, y2) & 0x1FE;
        int hash2 = Hash(seed, x3, y2) & 0x1FE;
        final float lx0x = Lerp(FastNoiseLite.RandVecs2D[hash0], FastNoiseLite.RandVecs2D[hash2], xs);
        final float ly0x = Lerp(FastNoiseLite.RandVecs2D[hash0 | 0x1], FastNoiseLite.RandVecs2D[hash2 | 0x1], xs);
        hash0 = (Hash(seed, x2, y3) & 0x1FE);
        hash2 = (Hash(seed, x3, y3) & 0x1FE);
        final float lx1x = Lerp(FastNoiseLite.RandVecs2D[hash0], FastNoiseLite.RandVecs2D[hash2], xs);
        final float ly1x = Lerp(FastNoiseLite.RandVecs2D[hash0 | 0x1], FastNoiseLite.RandVecs2D[hash2 | 0x1], xs);
        coord.x += Lerp(lx0x, lx1x, ys) * warpAmp;
        coord.y += Lerp(ly0x, ly1x, ys) * warpAmp;
    }
    
    private void SingleDomainWarpBasicGrid(final int seed, final float warpAmp, final float frequency, final float x, final float y, final float z, final Vector3 coord) {
        final float xf = x * frequency;
        final float yf = y * frequency;
        final float zf = z * frequency;
        int x2 = FastFloor(xf);
        int y2 = FastFloor(yf);
        int z2 = FastFloor(zf);
        final float xs = InterpHermite(xf - x2);
        final float ys = InterpHermite(yf - y2);
        final float zs = InterpHermite(zf - z2);
        x2 *= 501125321;
        y2 *= 1136930381;
        z2 *= 1720413743;
        final int x3 = x2 + 501125321;
        final int y3 = y2 + 1136930381;
        final int z3 = z2 + 1720413743;
        int hash0 = Hash(seed, x2, y2, z2) & 0x3FC;
        int hash2 = Hash(seed, x3, y2, z2) & 0x3FC;
        float lx0x = Lerp(FastNoiseLite.RandVecs3D[hash0], FastNoiseLite.RandVecs3D[hash2], xs);
        float ly0x = Lerp(FastNoiseLite.RandVecs3D[hash0 | 0x1], FastNoiseLite.RandVecs3D[hash2 | 0x1], xs);
        float lz0x = Lerp(FastNoiseLite.RandVecs3D[hash0 | 0x2], FastNoiseLite.RandVecs3D[hash2 | 0x2], xs);
        hash0 = (Hash(seed, x2, y3, z2) & 0x3FC);
        hash2 = (Hash(seed, x3, y3, z2) & 0x3FC);
        float lx1x = Lerp(FastNoiseLite.RandVecs3D[hash0], FastNoiseLite.RandVecs3D[hash2], xs);
        float ly1x = Lerp(FastNoiseLite.RandVecs3D[hash0 | 0x1], FastNoiseLite.RandVecs3D[hash2 | 0x1], xs);
        float lz1x = Lerp(FastNoiseLite.RandVecs3D[hash0 | 0x2], FastNoiseLite.RandVecs3D[hash2 | 0x2], xs);
        final float lx0y = Lerp(lx0x, lx1x, ys);
        final float ly0y = Lerp(ly0x, ly1x, ys);
        final float lz0y = Lerp(lz0x, lz1x, ys);
        hash0 = (Hash(seed, x2, y2, z3) & 0x3FC);
        hash2 = (Hash(seed, x3, y2, z3) & 0x3FC);
        lx0x = Lerp(FastNoiseLite.RandVecs3D[hash0], FastNoiseLite.RandVecs3D[hash2], xs);
        ly0x = Lerp(FastNoiseLite.RandVecs3D[hash0 | 0x1], FastNoiseLite.RandVecs3D[hash2 | 0x1], xs);
        lz0x = Lerp(FastNoiseLite.RandVecs3D[hash0 | 0x2], FastNoiseLite.RandVecs3D[hash2 | 0x2], xs);
        hash0 = (Hash(seed, x2, y3, z3) & 0x3FC);
        hash2 = (Hash(seed, x3, y3, z3) & 0x3FC);
        lx1x = Lerp(FastNoiseLite.RandVecs3D[hash0], FastNoiseLite.RandVecs3D[hash2], xs);
        ly1x = Lerp(FastNoiseLite.RandVecs3D[hash0 | 0x1], FastNoiseLite.RandVecs3D[hash2 | 0x1], xs);
        lz1x = Lerp(FastNoiseLite.RandVecs3D[hash0 | 0x2], FastNoiseLite.RandVecs3D[hash2 | 0x2], xs);
        coord.x += Lerp(lx0y, Lerp(lx0x, lx1x, ys), zs) * warpAmp;
        coord.y += Lerp(ly0y, Lerp(ly0x, ly1x, ys), zs) * warpAmp;
        coord.z += Lerp(lz0y, Lerp(lz0x, lz1x, ys), zs) * warpAmp;
    }
    
    private void SingleDomainWarpSimplexGradient(final int seed, final float warpAmp, final float frequency, float x, float y, final Vector2 coord, final boolean outGradOnly) {
        final float SQRT3 = 1.7320508f;
        final float G2 = 0.21132487f;
        x *= frequency;
        y *= frequency;
        int i = FastFloor(x);
        int j = FastFloor(y);
        final float xi = x - i;
        final float yi = y - j;
        final float t = (xi + yi) * 0.21132487f;
        final float x2 = xi - t;
        final float y2 = yi - t;
        i *= 501125321;
        j *= 1136930381;
        float vx;
        float vy = vx = 0.0f;
        final float a = 0.5f - x2 * x2 - y2 * y2;
        if (a > 0.0f) {
            final float aaaa = a * a * (a * a);
            float xo;
            float yo;
            if (outGradOnly) {
                final int hash = Hash(seed, i, j) & 0x1FE;
                xo = FastNoiseLite.RandVecs2D[hash];
                yo = FastNoiseLite.RandVecs2D[hash | 0x1];
            }
            else {
                final int hash = Hash(seed, i, j);
                final int index1 = hash & 0xFE;
                final int index2 = hash >> 7 & 0x1FE;
                final float xg = FastNoiseLite.Gradients2D[index1];
                final float yg = FastNoiseLite.Gradients2D[index1 | 0x1];
                final float value = x2 * xg + y2 * yg;
                final float xgo = FastNoiseLite.RandVecs2D[index2];
                final float ygo = FastNoiseLite.RandVecs2D[index2 | 0x1];
                xo = value * xgo;
                yo = value * ygo;
            }
            vx += aaaa * xo;
            vy += aaaa * yo;
        }
        final float c = 3.1547005f * t + (-0.6666666f + a);
        if (c > 0.0f) {
            final float x3 = x2 - 0.57735026f;
            final float y3 = y2 - 0.57735026f;
            final float cccc = c * c * (c * c);
            float xo2;
            float yo2;
            if (outGradOnly) {
                final int hash2 = Hash(seed, i + 501125321, j + 1136930381) & 0x1FE;
                xo2 = FastNoiseLite.RandVecs2D[hash2];
                yo2 = FastNoiseLite.RandVecs2D[hash2 | 0x1];
            }
            else {
                final int hash2 = Hash(seed, i + 501125321, j + 1136930381);
                final int index3 = hash2 & 0xFE;
                final int index4 = hash2 >> 7 & 0x1FE;
                final float xg2 = FastNoiseLite.Gradients2D[index3];
                final float yg2 = FastNoiseLite.Gradients2D[index3 | 0x1];
                final float value2 = x3 * xg2 + y3 * yg2;
                final float xgo2 = FastNoiseLite.RandVecs2D[index4];
                final float ygo2 = FastNoiseLite.RandVecs2D[index4 | 0x1];
                xo2 = value2 * xgo2;
                yo2 = value2 * ygo2;
            }
            vx += cccc * xo2;
            vy += cccc * yo2;
        }
        if (y2 > x2) {
            final float x4 = x2 + 0.21132487f;
            final float y4 = y2 - 0.7886751f;
            final float b = 0.5f - x4 * x4 - y4 * y4;
            if (b > 0.0f) {
                final float bbbb = b * b * (b * b);
                float xo3;
                float yo3;
                if (outGradOnly) {
                    final int hash3 = Hash(seed, i, j + 1136930381) & 0x1FE;
                    xo3 = FastNoiseLite.RandVecs2D[hash3];
                    yo3 = FastNoiseLite.RandVecs2D[hash3 | 0x1];
                }
                else {
                    final int hash3 = Hash(seed, i, j + 1136930381);
                    final int index5 = hash3 & 0xFE;
                    final int index6 = hash3 >> 7 & 0x1FE;
                    final float xg3 = FastNoiseLite.Gradients2D[index5];
                    final float yg3 = FastNoiseLite.Gradients2D[index5 | 0x1];
                    final float value3 = x4 * xg3 + y4 * yg3;
                    final float xgo3 = FastNoiseLite.RandVecs2D[index6];
                    final float ygo3 = FastNoiseLite.RandVecs2D[index6 | 0x1];
                    xo3 = value3 * xgo3;
                    yo3 = value3 * ygo3;
                }
                vx += bbbb * xo3;
                vy += bbbb * yo3;
            }
        }
        else {
            final float x4 = x2 - 0.7886751f;
            final float y4 = y2 + 0.21132487f;
            final float b = 0.5f - x4 * x4 - y4 * y4;
            if (b > 0.0f) {
                final float bbbb = b * b * (b * b);
                float xo3;
                float yo3;
                if (outGradOnly) {
                    final int hash3 = Hash(seed, i + 501125321, j) & 0x1FE;
                    xo3 = FastNoiseLite.RandVecs2D[hash3];
                    yo3 = FastNoiseLite.RandVecs2D[hash3 | 0x1];
                }
                else {
                    final int hash3 = Hash(seed, i + 501125321, j);
                    final int index5 = hash3 & 0xFE;
                    final int index6 = hash3 >> 7 & 0x1FE;
                    final float xg3 = FastNoiseLite.Gradients2D[index5];
                    final float yg3 = FastNoiseLite.Gradients2D[index5 | 0x1];
                    final float value3 = x4 * xg3 + y4 * yg3;
                    final float xgo3 = FastNoiseLite.RandVecs2D[index6];
                    final float ygo3 = FastNoiseLite.RandVecs2D[index6 | 0x1];
                    xo3 = value3 * xgo3;
                    yo3 = value3 * ygo3;
                }
                vx += bbbb * xo3;
                vy += bbbb * yo3;
            }
        }
        coord.x += vx * warpAmp;
        coord.y += vy * warpAmp;
    }
    
    private void SingleDomainWarpOpenSimplex2Gradient(int seed, final float warpAmp, final float frequency, float x, float y, float z, final Vector3 coord, final boolean outGradOnly) {
        x *= frequency;
        y *= frequency;
        z *= frequency;
        int i = FastRound(x);
        int j = FastRound(y);
        int k = FastRound(z);
        float x2 = x - i;
        float y2 = y - j;
        float z2 = z - k;
        int xNSign = (int)(-x2 - 1.0f) | 0x1;
        int yNSign = (int)(-y2 - 1.0f) | 0x1;
        int zNSign = (int)(-z2 - 1.0f) | 0x1;
        float ax0 = xNSign * -x2;
        float ay0 = yNSign * -y2;
        float az0 = zNSign * -z2;
        i *= 501125321;
        j *= 1136930381;
        k *= 1720413743;
        float vz;
        float vx;
        float vy = vx = (vz = 0.0f);
        float a = 0.6f - x2 * x2 - (y2 * y2 + z2 * z2);
        int l = 0;
        while (true) {
            if (a > 0.0f) {
                final float aaaa = a * a * (a * a);
                float xo;
                float yo;
                float zo;
                if (outGradOnly) {
                    final int hash = Hash(seed, i, j, k) & 0x3FC;
                    xo = FastNoiseLite.RandVecs3D[hash];
                    yo = FastNoiseLite.RandVecs3D[hash | 0x1];
                    zo = FastNoiseLite.RandVecs3D[hash | 0x2];
                }
                else {
                    final int hash = Hash(seed, i, j, k);
                    final int index1 = hash & 0xFC;
                    final int index2 = hash >> 6 & 0x3FC;
                    final float xg = FastNoiseLite.Gradients3D[index1];
                    final float yg = FastNoiseLite.Gradients3D[index1 | 0x1];
                    final float zg = FastNoiseLite.Gradients3D[index1 | 0x2];
                    final float value = x2 * xg + y2 * yg + z2 * zg;
                    final float xgo = FastNoiseLite.RandVecs3D[index2];
                    final float ygo = FastNoiseLite.RandVecs3D[index2 | 0x1];
                    final float zgo = FastNoiseLite.RandVecs3D[index2 | 0x2];
                    xo = value * xgo;
                    yo = value * ygo;
                    zo = value * zgo;
                }
                vx += aaaa * xo;
                vy += aaaa * yo;
                vz += aaaa * zo;
            }
            float b = a;
            int i2 = i;
            int j2 = j;
            int k2 = k;
            float x3 = x2;
            float y3 = y2;
            float z3 = z2;
            if (ax0 >= ay0 && ax0 >= az0) {
                x3 += xNSign;
                b = b + ax0 + ax0;
                i2 -= xNSign * 501125321;
            }
            else if (ay0 > ax0 && ay0 >= az0) {
                y3 += yNSign;
                b = b + ay0 + ay0;
                j2 -= yNSign * 1136930381;
            }
            else {
                z3 += zNSign;
                b = b + az0 + az0;
                k2 -= zNSign * 1720413743;
            }
            if (b > 1.0f) {
                --b;
                final float bbbb = b * b * (b * b);
                float xo2;
                float yo2;
                float zo2;
                if (outGradOnly) {
                    final int hash2 = Hash(seed, i2, j2, k2) & 0x3FC;
                    xo2 = FastNoiseLite.RandVecs3D[hash2];
                    yo2 = FastNoiseLite.RandVecs3D[hash2 | 0x1];
                    zo2 = FastNoiseLite.RandVecs3D[hash2 | 0x2];
                }
                else {
                    final int hash2 = Hash(seed, i2, j2, k2);
                    final int index3 = hash2 & 0xFC;
                    final int index4 = hash2 >> 6 & 0x3FC;
                    final float xg2 = FastNoiseLite.Gradients3D[index3];
                    final float yg2 = FastNoiseLite.Gradients3D[index3 | 0x1];
                    final float zg2 = FastNoiseLite.Gradients3D[index3 | 0x2];
                    final float value2 = x3 * xg2 + y3 * yg2 + z3 * zg2;
                    final float xgo2 = FastNoiseLite.RandVecs3D[index4];
                    final float ygo2 = FastNoiseLite.RandVecs3D[index4 | 0x1];
                    final float zgo2 = FastNoiseLite.RandVecs3D[index4 | 0x2];
                    xo2 = value2 * xgo2;
                    yo2 = value2 * ygo2;
                    zo2 = value2 * zgo2;
                }
                vx += bbbb * xo2;
                vy += bbbb * yo2;
                vz += bbbb * zo2;
            }
            if (l == 1) {
                break;
            }
            ax0 = 0.5f - ax0;
            ay0 = 0.5f - ay0;
            az0 = 0.5f - az0;
            x2 = xNSign * ax0;
            y2 = yNSign * ay0;
            z2 = zNSign * az0;
            a += 0.75f - ax0 - (ay0 + az0);
            i += (xNSign >> 1 & 0x1DDE90C9);
            j += (yNSign >> 1 & 0x43C42E4D);
            k += (zNSign >> 1 & 0x668B6E2F);
            xNSign = -xNSign;
            yNSign = -yNSign;
            zNSign = -zNSign;
            seed += 1293373;
            ++l;
        }
        coord.x += vx * warpAmp;
        coord.y += vy * warpAmp;
        coord.z += vz * warpAmp;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType() {
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType = FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType;
        if ($switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType != null) {
            return $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType;
        }
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType2 = new int[NoiseType.values().length];
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType2[NoiseType.Cellular.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType2[NoiseType.OpenSimplex2.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType2[NoiseType.OpenSimplex2S.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType2[NoiseType.Perlin.ordinal()] = 4;
        }
        catch (final NoSuchFieldError noSuchFieldError4) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType2[NoiseType.Value.ordinal()] = 6;
        }
        catch (final NoSuchFieldError noSuchFieldError5) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType2[NoiseType.ValueCubic.ordinal()] = 5;
        }
        catch (final NoSuchFieldError noSuchFieldError6) {}
        return FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType = $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$NoiseType2;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType() {
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType = FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType;
        if ($switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType != null) {
            return $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType;
        }
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType2 = new int[FractalType.values().length];
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType2[FractalType.DomainWarpIndependent.ordinal()] = 6;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType2[FractalType.DomainWarpProgressive.ordinal()] = 5;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType2[FractalType.FBm.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType2[FractalType.None.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError4) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType2[FractalType.PingPong.ordinal()] = 4;
        }
        catch (final NoSuchFieldError noSuchFieldError5) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType2[FractalType.Ridged.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError6) {}
        return FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType = $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$FractalType2;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D() {
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D = FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D;
        if ($switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D != null) {
            return $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D;
        }
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D2 = new int[TransformType3D.values().length];
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D2[TransformType3D.DefaultOpenSimplex2.ordinal()] = 4;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D2[TransformType3D.ImproveXYPlanes.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D2[TransformType3D.ImproveXZPlanes.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D2[TransformType3D.None.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError4) {}
        return FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D = $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$TransformType3D2;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D() {
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D = FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D;
        if ($switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D != null) {
            return $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D;
        }
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D2 = new int[RotationType3D.values().length];
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D2[RotationType3D.ImproveXYPlanes.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D2[RotationType3D.ImproveXZPlanes.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D2[RotationType3D.None.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        return FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D = $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$RotationType3D2;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType() {
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType = FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType;
        if ($switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType != null) {
            return $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType;
        }
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType2 = new int[DomainWarpType.values().length];
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType2[DomainWarpType.BasicGrid.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType2[DomainWarpType.OpenSimplex2.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType2[DomainWarpType.OpenSimplex2Reduced.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        return FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType = $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$DomainWarpType2;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction() {
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction = FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction;
        if ($switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction != null) {
            return $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction;
        }
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction2 = new int[CellularDistanceFunction.values().length];
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction2[CellularDistanceFunction.Euclidean.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction2[CellularDistanceFunction.EuclideanSq.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction2[CellularDistanceFunction.Hybrid.ordinal()] = 4;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction2[CellularDistanceFunction.Manhattan.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError4) {}
        return FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction = $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularDistanceFunction2;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType() {
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType = FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType;
        if ($switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType != null) {
            return $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType;
        }
        final int[] $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType2 = new int[CellularReturnType.values().length];
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType2[CellularReturnType.CellValue.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType2[CellularReturnType.Distance.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType2[CellularReturnType.Distance2.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType2[CellularReturnType.Distance2Add.ordinal()] = 4;
        }
        catch (final NoSuchFieldError noSuchFieldError4) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType2[CellularReturnType.Distance2Div.ordinal()] = 7;
        }
        catch (final NoSuchFieldError noSuchFieldError5) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType2[CellularReturnType.Distance2Mul.ordinal()] = 6;
        }
        catch (final NoSuchFieldError noSuchFieldError6) {}
        try {
            $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType2[CellularReturnType.Distance2Sub.ordinal()] = 5;
        }
        catch (final NoSuchFieldError noSuchFieldError7) {}
        return FastNoiseLite.$SWITCH_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType = $switch_TABLE$xyz$cucumber$base$utils$math$FastNoiseLite$CellularReturnType2;
    }
}
