using System;
using Android.Graphics;
using Android.OS;
using Android.Runtime;
using Android.Text;
using Android.Text.Style;

namespace MathirialDesign.Utilities
{
    /// <summary>
    /// Currently, TypefaceSpan is not working for Xamarin.Android.
    /// In order for it to work, we use this version instead.
    /// </summary>
    public class CustomTypefaceSpan : TypefaceSpan
    {
        private readonly Typeface _typeface;

        public CustomTypefaceSpan(Typeface typeface)
            : base(string.Empty)
        {
            _typeface = typeface;
        }

        public CustomTypefaceSpan(Parcel src)
            : base(src)
        {
        }

        public CustomTypefaceSpan(string family)
            : base(family)
        {
        }

        protected CustomTypefaceSpan(
            IntPtr javaReference,
            JniHandleOwnership transfer)
            : base(javaReference, transfer)
        {
        }

        public override void UpdateDrawState(TextPaint ds)
        {
            ApplyTypeface(ds, _typeface);
        }

        public override void UpdateMeasureState(TextPaint paint)
        {
            ApplyTypeface(paint, _typeface);
        }

        private static void ApplyTypeface(Paint paint, Typeface typeface)
        {
            paint.SetTypeface(typeface);
        }
    }
}